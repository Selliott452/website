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

@Route(value = "leagues/demonic-pacts/relics/larcenist", layout = MainLayout::class)
@PageTitle("Larcenist")
class LarcenistView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Larcenist"))
        add(RelicDetailCard("Larcenist", "images/relics/larcenist.png",
            UnorderedList(
                ListItem("100% success rate on all Thieving actions."),
                ListItem("Automatically re-pickpockets NPCs and re-steals from stalls."),
                ListItem("All items from pickpocketing and stalls are noted; stalls never deplete."),
                ListItem("10x coin pouch capacity."),
                ListItem("10x loot from pickpocketing, stalls, and stealing house valuables.")
            )))
    }
}
