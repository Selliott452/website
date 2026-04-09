package com.elliott.website.views.runescape.relics

import com.elliott.website.models.ButlersBellData
import com.elliott.website.models.ResourceCategory
import com.elliott.website.services.ButlersBellCalculator
import com.elliott.website.services.CategoryResult
import com.elliott.website.services.ItemResult
import com.elliott.website.services.TimeToLevelResult
import com.elliott.website.views.MainLayout
import com.elliott.website.views.components.RelicDetailCard
import com.elliott.website.views.runescape.RelicsView
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.checkbox.Checkbox
import com.vaadin.flow.component.html.*
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.select.Select
import com.vaadin.flow.component.textfield.IntegerField
import com.vaadin.flow.component.textfield.NumberField
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLink
import java.text.DecimalFormat

@Route(value = "leagues/demonic-pacts/relics/butlers-bell", layout = MainLayout::class)
@PageTitle("Butler's Bell")
class ButlersBellView : VerticalLayout() {

    private val fmt = DecimalFormat("#,###.#")
    private val calc = ButlersBellCalculator()

    init {
        addClassName("content-view")
        defaultHorizontalComponentAlignment = FlexComponent.Alignment.STRETCH
        maxWidth = "960px"
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Butler's Bell"))
        add(RelicDetailCard("Butler's Bell", "images/relics/butlers-bell.png",
            UnorderedList(
                ListItem("Grants the Butler's bell; ring it to summon a demon butler who works even while offline."),
                ListItem("Gathering rates: 8 ores/min, 14 fish/min, 10 logs/min, 50 flax/min, 10 herbs/min."),
                ListItem("Processes at half rates: ores into bars, fish cooked, logs into planks, flax into bowstrings, herbs into unfinished potions."),
                ListItem("Grants 10 XP (before league multipliers) per resource processed in the relevant production skill.")
            )))

        add(buildResourceCalculator())
        add(buildTimeToLevelCalculator())
    }

    // ── Calculators ─────────────────────────────────────────────────────

    private fun buildResourceCalculator(): Div {
        val categorySelect = buildCategorySelect()
        val multiplierSelect = buildMultiplierSelect()
        val processingCheckbox = Checkbox("Include processing")
        val hoursField = NumberField("Duration (hours)").apply {
            value = 1.0; min = 0.0; step = 0.5; isStepButtonsVisible = true; width = "180px"
        }
        val outputPanel = Div().apply { addClassName("calculator-output") }

        val update = {
            val category = categorySelect.value
            if (category != null) {
                val result = calc.calculateCategory(
                    category, hoursField.value ?: 1.0,
                    multiplierSelect.value ?: 8, processingCheckbox.value
                )
                outputPanel.removeAll()
                outputPanel.add(renderResultTable(result, processingCheckbox.value))
            }
        }

        listOf(categorySelect, multiplierSelect, processingCheckbox, hoursField).forEach {
            it.addValueChangeListener { update() }
        }
        categorySelect.value = ResourceCategory.FISH

        return calculatorSection("Resource & XP Calculator",
            listOf(categorySelect, multiplierSelect, processingCheckbox, hoursField), outputPanel)
    }

    private fun buildTimeToLevelCalculator(): Div {
        val categorySelect = buildCategorySelect()
        val multiplierSelect = buildMultiplierSelect()
        val currentLevelField = IntegerField("Current Level").apply {
            value = 1; min = 1; max = 98; isStepButtonsVisible = true; width = "150px"
        }
        val targetLevelField = IntegerField("Target Level").apply {
            value = 99; min = 2; max = 99; isStepButtonsVisible = true; width = "150px"
        }
        val outputPanel = Div().apply { addClassName("calculator-output") }

        val update = {
            outputPanel.removeAll()
            val category = categorySelect.value
            if (category != null) {
                val result = calc.calculateTimeToLevel(
                    category, multiplierSelect.value ?: 8,
                    currentLevelField.value ?: 1, targetLevelField.value ?: 99
                )
                when {
                    result != null -> {
                        outputPanel.add(renderTtlSummary(result))
                        outputPanel.add(renderResultTable(result.breakdown, true))
                    }
                    (targetLevelField.value ?: 99) <= (currentLevelField.value ?: 1) ->
                        outputPanel.add(noteSpan("Target level must be higher than current level."))
                    else ->
                        outputPanel.add(noteSpan("No processing XP available for this category."))
                }
            }
        }

        listOf(categorySelect, multiplierSelect, currentLevelField, targetLevelField).forEach {
            it.addValueChangeListener { update() }
        }
        categorySelect.value = ResourceCategory.FISH

        return calculatorSection("Time to Level",
            listOf(categorySelect, multiplierSelect, currentLevelField, targetLevelField), outputPanel)
    }

    private fun calculatorSection(title: String, inputs: List<Component>, output: Div): Div {
        return Div().apply {
            addClassName("calculator-section")
            add(H3(title))
            add(Div().apply {
                addClassName("calculator-inputs")
                inputs.forEach { add(it) }
            })
            add(output)
        }
    }

    // ── Table Rendering ─────────────────────────────────────────────────

    private fun renderResultTable(result: CategoryResult, includeProcessing: Boolean): Div {
        val table = Div().apply { addClassName("calc-table") }

        table.add(headerRow(includeProcessing))
        result.items.forEach { table.add(itemRow(it, includeProcessing)) }
        table.add(totalsRow(result, includeProcessing))

        return Div().apply { addClassName("calc-table-wrapper"); add(table) }
    }

    private fun headerRow(includeProcessing: Boolean): Div {
        val row = Div().apply { addClassName("calc-table-header") }
        row.add(textCell("Item", "calc-cell-item"))
        row.add(textCell("Qty / hr", "calc-cell-num"))
        row.add(textCell("Total Qty", "calc-cell-num"))
        if (includeProcessing) {
            row.add(textCell("Processed", "calc-cell-item"))
            row.add(textCell("Proc / hr", "calc-cell-num"))
            row.add(textCell("Total Proc", "calc-cell-num"))
            row.add(textCell("XP / hr", "calc-cell-num"))
            row.add(textCell("Total XP", "calc-cell-num"))
        }
        return row
    }

    private fun itemRow(r: ItemResult, includeProcessing: Boolean): Div {
        val row = Div().apply { addClassName("calc-table-row") }
        row.add(iconCell(r.item.rawImageUrl(), r.item.rawName))
        row.add(numCell(r.gatherPerHour))
        row.add(numCell(r.totalGathered))
        if (includeProcessing) {
            row.add(iconCell(r.item.processedImageUrl(), r.item.processedName))
            row.add(numCell(r.processPerHour))
            row.add(numCell(r.totalProcessed))
            row.add(numCell(r.xpPerHour))
            row.add(numCell(r.totalXp))
        }
        return row
    }

    private fun totalsRow(result: CategoryResult, includeProcessing: Boolean): Div {
        val row = Div().apply { addClassNames("calc-table-row", "calc-table-totals") }
        row.add(Span("Total").apply { addClassNames("calc-cell", "calc-cell-item", "calc-total-label") })
        row.add(numCell(result.totalGatherPerHour))
        row.add(numCell(result.totalGathered))
        if (includeProcessing) {
            row.add(textCell("", "calc-cell-item"))
            row.add(numCell(result.totalProcessPerHour))
            row.add(numCell(result.totalProcessed))
            row.add(numCell(result.totalXpPerHour))
            row.add(numCell(result.totalXp))
        }
        return row
    }

    private fun renderTtlSummary(result: TimeToLevelResult): Div {
        return Div().apply {
            addClassName("calc-ttl-summary")
            add(labelValue("XP needed:", fmt.format(result.xpNeeded)))
            add(labelValue("Processing XP/hr:", fmt.format(result.xpPerHour)))
            add(labelValue("Time required:", calc.formatDuration(result.hoursNeeded * 60.0)))
        }
    }

    // ── Cell Helpers ────────────────────────────────────────────────────

    private fun numCell(value: Double) = Span(fmt.format(value)).apply {
        addClassNames("calc-cell", "calc-cell-num")
    }

    private fun textCell(text: String, vararg extraClasses: String) = Span(text).apply {
        addClassNames("calc-cell", *extraClasses)
    }

    private fun iconCell(imageUrl: String, name: String) = Div().apply {
        addClassNames("calc-cell", "calc-cell-item")
        add(Image(imageUrl, name).apply { addClassName("calc-item-icon") })
        add(Span(name))
    }

    private fun labelValue(label: String, value: String) = Div().apply {
        add(Span(label).apply { addClassName("calc-label") })
        add(Span(value).apply { addClassName("calc-value") })
    }

    private fun noteSpan(text: String) = Span(text).apply { addClassName("calc-note") }

    // ── Input Helpers ───────────────────────────────────────────────────

    private fun buildCategorySelect() = Select<ResourceCategory>().apply {
        label = "Category"
        setItems(ResourceCategory.entries)
        setItemLabelGenerator { it.displayName }
        width = "160px"
    }

    private fun buildMultiplierSelect() = Select<Int>().apply {
        label = "XP Multiplier"
        setItems(ButlersBellData.XP_MULTIPLIERS)
        setItemLabelGenerator { "${it}x" }
        value = 8
        width = "130px"
    }
}
