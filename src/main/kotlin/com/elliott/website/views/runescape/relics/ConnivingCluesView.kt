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

@Route(value = "leagues/demonic-pacts/relics/conniving-clues", layout = MainLayout::class)
@PageTitle("Conniving Clues")
class ConnivingCluesView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Conniving Clues"))
        add(RelicDetailCard("Conniving Clues", "images/relics/conniving-clues.png",
            UnorderedList(
                ListItem("When opening a reward casket, 1/3 chance to receive clue contracts which teleport you to your current clue step."),
                ListItem("Reward caskets have a 1/4 chance to contain a clue scroll box of the same tier."),
                ListItem("Clue drop rate from creatures and impling jars is 1/15."),
                ListItem("All clues have the lowest possible number of steps and maximum reward rolls."),
                ListItem("Emote and Falo clue steps no longer have item requirements.")
            )))
    }
}
