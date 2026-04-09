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

@Route(value = "leagues/demonic-pacts/relics/abundance", layout = MainLayout::class)
@PageTitle("Abundance")
class AbundanceView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Abundance"))
        add(RelicDetailCard("Abundance", "images/relics/abundance.png",
            UnorderedList(
                ListItem("All non-combat skills are permanently boosted by 10."),
                ListItem("Every time you receive an XP drop, gain an additional 2 XP in the same skill."),
                ListItem("For every XP gained, gain 2x as many coins.")
            )))
    }
}
