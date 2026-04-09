package com.elliott.website.views.runescape.relics

import com.elliott.website.views.MainLayout
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@Route(value = "leagues/demonic-pacts/relics/evil-eye", layout = MainLayout::class)
@PageTitle("Evil Eye")
class EvilEyeView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(H2("Evil Eye"))
    }
}
