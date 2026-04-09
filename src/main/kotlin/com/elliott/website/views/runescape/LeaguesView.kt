package com.elliott.website.views.runescape

import com.elliott.website.views.MainLayout
import com.elliott.website.views.components.NavCard
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(value = "leagues", layout = MainLayout::class)
@PageTitle("Leagues")
class LeaguesView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(
            H2("Leagues"),
            VerticalLayout().apply {
                addClassName("nav-card-section")
                isPadding = false
                add(
                    HorizontalLayout().apply {
                        addClassName("nav-card-grid")
                        add(NavCard("Demonic Pacts", "Tools and Information on things in the Demonic Pacts league.", DemonicPactsView::class.java))
                    }
                )
            }
        )
    }
}
