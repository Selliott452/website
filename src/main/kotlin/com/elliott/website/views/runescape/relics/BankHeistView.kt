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

@Route(value = "leagues/demonic-pacts/relics/bank-heist", layout = MainLayout::class)
@PageTitle("Bank Heist")
class BankHeistView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Bank Heist"))
        add(RelicDetailCard("Bank Heist", "images/relics/bank-heist.png",
            UnorderedList(
                ListItem("Teleport to any bank, bank chest, or deposit box."),
                ListItem("Ignores wilderness teleport restrictions."),
                ListItem("Cannot be used to teleport to areas you haven't unlocked.")
            )))
    }
}
