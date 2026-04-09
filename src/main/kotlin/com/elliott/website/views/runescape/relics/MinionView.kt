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

@Route(value = "leagues/demonic-pacts/relics/minion", layout = MainLayout::class)
@PageTitle("Minion")
class MinionView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Minion"))
        add(RelicDetailCard("Minion", "images/relics/minion.png",
            UnorderedList(
                ListItem("Grants the minion whistle, summoning a combat minion for 30 minutes."),
                ListItem("Stats: Min hit 3, Max hit 10, Attack speed 1.8s, Accuracy 45,000."),
                ListItem("Use up to 5 unique Zamorak items on the whistle to increase the minion's max hit by 2 each."),
                ListItem("Auto-loots items from killed creatures with a configurable value threshold and noting option."),
                ListItem("Casts AoE attacks in multi-combat against targets weak to range or magic."),
                ListItem("Will not fight in PvP or against Yama.")
            )))
    }
}
