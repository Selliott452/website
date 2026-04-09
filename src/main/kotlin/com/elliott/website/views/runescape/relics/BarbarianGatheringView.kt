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

@Route(value = "leagues/demonic-pacts/relics/barbarian-gathering", layout = MainLayout::class)
@PageTitle("Barbarian Gathering")
class BarbarianGatheringView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Barbarian Gathering"))
        add(RelicDetailCard("Barbarian Gathering", "images/relics/barbarian-gathering.png",
            UnorderedList(
                ListItem("Grants the knapsack, holding up to 3 types of gathered items with a total capacity of 140."),
                ListItem("Gather wood, fish, and ore bare-handed at crystal tool speed without tools or bait."),
                ListItem("Gain 10% bonus Strength and Agility XP whenever you gain Fishing, Woodcutting, or Mining XP."),
                ListItem("On a failed gather attempt, you have an additional 50% chance to succeed.")
            )))
    }
}
