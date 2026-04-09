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

@Route(value = "leagues/demonic-pacts/relics/friendly-forager", layout = MainLayout::class)
@PageTitle("Friendly Forager")
class FriendlyForagerView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Friendly Forager"))
        add(RelicDetailCard("Friendly Forager", "images/relics/friendly-forager.png",
            UnorderedList(
                ListItem("Grants the forager's pouch, which finds a random grimy herb when you gather from Woodcutting, Fishing, Mining, or Hunter."),
                ListItem("All herblore items are processed at once."),
                ListItem("Secondary ingredients have a 90% chance to not be consumed."),
                ListItem("Potions created will have 4 doses instead of 3.")
            )))
    }
}
