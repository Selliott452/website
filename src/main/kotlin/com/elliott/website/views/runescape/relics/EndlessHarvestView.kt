package com.elliott.website.views.runescape.relics

import com.elliott.website.views.MainLayout
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(value = "leagues/demonic-pacts/relics/endless-harvest", layout = MainLayout::class)
@PageTitle("Endless Harvest")
class EndlessHarvestView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(H2("Endless Harvest"))
    }
}
