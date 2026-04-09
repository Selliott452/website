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

@Route(value = "leagues/demonic-pacts/relics/transmutation", layout = MainLayout::class)
@PageTitle("Transmutation")
class TransmutationView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Transmutation"))
        add(RelicDetailCard("Transmutation", "images/relics/transmutation.png",
            UnorderedList(
                ListItem("Grants the Transmutation ledger."),
                ListItem("Alchemic Divergence: upgrades up to 10 of a resource into a higher tier."),
                ListItem("Alchemic Convergence: downgrades up to 10 of a resource into a lower tier."),
                ListItem("Both spells cost 1 Nature rune with no level requirement, granting 10 Magic XP per item."),
                ListItem("The ledger can be equipped and acts as an infinite source of Nature runes."),
                ListItem("Casting on noted items will automatically re-cast as long as resources are available.")
            )))
    }
}
