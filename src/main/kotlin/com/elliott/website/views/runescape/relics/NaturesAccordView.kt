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

@Route(value = "leagues/demonic-pacts/relics/natures-accord", layout = MainLayout::class)
@PageTitle("Nature's Accord")
class NaturesAccordView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Nature's Accord"))
        add(RelicDetailCard("Nature's Accord", "images/relics/natures-accord.png",
            UnorderedList(
                ListItem("Grants the fairy mushroom, allowing teleportation to any fairy ring, spirit tree, or tool leprechaun."),
                ListItem("Farming patches have no level requirements."),
                ListItem("10x yield from all farming patches, automatically noted."),
                ListItem("Plants never die; 20% chance to not consume a seed or sapling when planting."),
                ListItem("Autocompletes the Tree Gnome Village quest.")
            )))
    }
}
