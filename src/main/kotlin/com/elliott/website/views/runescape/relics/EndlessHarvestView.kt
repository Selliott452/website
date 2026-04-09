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

@Route(value = "leagues/demonic-pacts/relics/endless-harvest", layout = MainLayout::class)
@PageTitle("Endless Harvest")
class EndlessHarvestView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Endless Harvest"))
        add(RelicDetailCard("Endless Harvest", "images/relics/endless-harvest.png",
            UnorderedList(
                ListItem("Toggleable: all resources gathered will be sent to the bank."),
                ListItem("Endlessly gather from fishing spots, trees, and mining rocks even if they deplete."),
                ListItem("Resources gathered from Fishing, Woodcutting, and Mining are multiplied by 2."),
                ListItem("XP is granted for all additional resources gathered.")
            )))
    }
}
