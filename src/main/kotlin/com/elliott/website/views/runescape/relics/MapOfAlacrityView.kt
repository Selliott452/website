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

@Route(value = "leagues/demonic-pacts/relics/map-of-alacrity", layout = MainLayout::class)
@PageTitle("Map of Alacrity")
class MapOfAlacrityView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Map of Alacrity"))
        add(RelicDetailCard("Map of Alacrity", "images/relics/map-of-alacrity.png",
            UnorderedList(
                ListItem("Grants the map of alacrity."),
                ListItem("Teleport to agility shortcuts."),
                ListItem("You will be placed on the less favourable side, or the starting side for one-way shortcuts."),
                ListItem("All shortcut requirements still apply."),
                ListItem("Ignores wilderness teleport restrictions.")
            )))
    }
}
