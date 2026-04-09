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

@Route(value = "leagues/demonic-pacts/relics/grimoire", layout = MainLayout::class)
@PageTitle("Grimoire")
class GrimoireView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Grimoire"))
        add(RelicDetailCard("Grimoire", "images/relics/grimoire.png",
            UnorderedList(
                ListItem("Grants the arcane grimoire for freely swapping between spellbooks."),
                ListItem("Acts as a book of the dead."),
                ListItem("Unlocks all prayers and spells regardless of area, quest, or diary requirements.")
            )))
    }
}
