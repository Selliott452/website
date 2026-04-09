package com.elliott.website.views.runescape.relics

import com.elliott.website.views.MainLayout
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(value = "leagues/demonic-pacts/relics/abundance", layout = MainLayout::class)
@PageTitle("Abundance")
class AbundanceView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(H2("Abundance"))
    }
}
