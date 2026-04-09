package com.elliott.website.views.runescape.relics

import com.elliott.website.views.MainLayout
import com.elliott.website.views.components.RelicDetailCard
import com.elliott.website.views.runescape.RelicsView
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.ListItem
import com.vaadin.flow.component.html.UnorderedList
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLink

@Route(value = "leagues/demonic-pacts/relics/butlers-bell", layout = MainLayout::class)
@PageTitle("Butler's Bell")
class ButlersBellView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Butler's Bell"))
        add(RelicDetailCard("Butler's Bell", "images/relics/butlers-bell.png",
            UnorderedList(
                ListItem("Grants the Butler's bell; ring it to summon a demon butler who works even while offline."),
                ListItem("Gathering rates: 8 ores/min, 14 fish/min, 10 logs/min, 50 flax/min, 10 herbs/min."),
                ListItem("Processes at half rates: ores into bars, fish cooked, logs into planks, flax into bowstrings, herbs into unfinished potions."),
                ListItem("Grants 10 XP (before league multipliers) per resource processed in the relevant production skill.")
            )))
    }
}
