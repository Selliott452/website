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

@Route(value = "leagues/demonic-pacts/relics/soul-harvest", layout = MainLayout::class)
@PageTitle("Soul Harvest")
class SoulHarvestView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(RouterLink("Back to Relics", RelicsView::class.java).apply { addClassName("back-link") })
        add(H2("Soul Harvest"))
        add(RelicDetailCard("Soul Harvest", "images/relics/soul-harvest.png",
            UnorderedList(
                ListItem("Dropped bones and ashes are converted into stackable soul shards."),
                ListItem("Soul shards can be used in place of pure essence for Runecraft."),
                ListItem("100 shards can be sacrificed at the libation bowl at the Teomat for 550 Prayer XP (before league multipliers)."),
                ListItem("Receive 1 shard per 4 XP gained while harvesting crops."),
                ListItem("Higher tier bones and ashes give more shards proportionally.")
            )))
    }
}
