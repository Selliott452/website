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

@Route(value = "leagues/demonic-pacts/relics/hotfoot", layout = MainLayout::class)
@PageTitle("Hotfoot")
class HotfootView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Hotfoot"))
        add(RelicDetailCard("Hotfoot", "images/relics/hotfoot.png",
            UnorderedList(
                ListItem("Grants searing boots."),
                ListItem("Caught fish are automatically cooked; mined ore is automatically smelted."),
                ListItem("Agility XP is gained based on your level while you run."),
                ListItem("100% success rate on all Agility and Cooking actions."),
                ListItem("Completing an agility course grants 2 completion count and 25% bonus XP."),
                ListItem("Marks of grace always have a 33% spawn chance on rooftop courses."),
                ListItem("2x termites from the Colossal Wyrm Agility Course; 10x crystal shards from the Prifddinas Agility Course.")
            )))
    }
}
