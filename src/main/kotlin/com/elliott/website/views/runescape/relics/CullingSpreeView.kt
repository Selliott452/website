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

@Route(value = "leagues/demonic-pacts/relics/culling-spree", layout = MainLayout::class)
@PageTitle("Culling Spree")
class CullingSpreeView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Culling Spree"))
        add(RelicDetailCard("Culling Spree", "images/relics/culling-spree.png",
            UnorderedList(
                ListItem("Choose your slayer task from 3 options, with at least 1 boss task if possible."),
                ListItem("Kill count is selectable for all tasks (5–200)."),
                ListItem("50% chance for superior monsters to spawn another superior on death."),
                ListItem("Superior monsters always drop 1–3 elite clue scrolls."),
                ListItem("All slayer helmet effects apply without needing to wear one."),
                ListItem("All slayer reward shop perks are free, including Rune pouch, Herb sack, and Looting bag.")
            )))
    }
}
