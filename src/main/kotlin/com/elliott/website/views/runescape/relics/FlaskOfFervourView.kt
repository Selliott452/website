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

@Route(value = "leagues/demonic-pacts/relics/flask-of-fervour", layout = MainLayout::class)
@PageTitle("Flask of Fervour")
class FlaskOfFervourView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Flask of Fervour"))
        add(RelicDetailCard("Flask of Fervour", "images/relics/flask-of-fervour.png",
            UnorderedList(
                ListItem("Grants the flask of fervour, fully restoring Hitpoints, Prayer, and Special Attack energy."),
                ListItem("Over 2.4 seconds, triggers three explosions dealing 60% of your base Prayer level (30% in PvP) as typeless damage within 3 tiles."),
                ListItem("Reduces all damage taken to 0 during the explosion period."),
                ListItem("Base cooldown of 3 minutes, reduced by 0.6 seconds for every 10 damage dealt in a single hit."),
                ListItem("Also works inside the Gauntlet.")
            )))
    }
}
