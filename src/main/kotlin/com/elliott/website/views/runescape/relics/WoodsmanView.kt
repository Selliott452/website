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

@Route(value = "leagues/demonic-pacts/relics/woodsman", layout = MainLayout::class)
@PageTitle("Woodsman")
class WoodsmanView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Woodsman"))
        add(RelicDetailCard("Woodsman", "images/relics/woodsman.png",
            UnorderedList(
                ListItem("Hunter traps harvest directly to your bank."),
                ListItem("Logs chopped are automatically burned, granting full Firemaking XP (toggleable)."),
                ListItem("100% success rate on all Hunter actions."),
                ListItem("Hunter traps attract animals faster, give double loot and XP, and always drop a random herb or tree seed."),
                ListItem("Hunter rumours give double XP; Hunter's loot sacks award 2x loot."),
                ListItem("All loot from jarred implings is doubled and noted.")
            )))
    }
}
