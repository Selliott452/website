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

@Route(value = "leagues/demonic-pacts/relics/evil-eye", layout = MainLayout::class)
@PageTitle("Evil Eye")
class EvilEyeView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Evil Eye"))
        add(RelicDetailCard("Evil Eye", "images/relics/evil-eye.png",
            UnorderedList(
                ListItem("Grants the evil eye."),
                ListItem("Teleport to the entrance of any boss or raid in the combat achievements list."),
                ListItem("Barrows offers the option to go to the chest or the surface."),
                ListItem("Each Moon of Peril can be teleported to individually."),
                ListItem("Ignores wilderness teleport restrictions."),
                ListItem("Cannot be used to teleport to areas you haven't unlocked.")
            )))
    }
}
