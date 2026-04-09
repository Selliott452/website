package com.elliott.website.views.runescape

import com.elliott.website.views.MainLayout
import com.elliott.website.views.components.NavCard
import com.elliott.website.views.runescape.relics.*
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.H3
import com.vaadin.flow.component.html.ListItem
import com.vaadin.flow.component.html.UnorderedList
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

private const val RELICS_IMG = "images/relics"

@Route(value = "leagues/demonic-pacts/relics", layout = MainLayout::class)
@PageTitle("Relics")
class RelicsView : VerticalLayout() {
    init {
        addClassName("content-view")
        add(H2("Relics"))

        addTierSection("Tier 1",
            passive = listOf(
                "Leagues XP multiplier is 5x.",
                "Items from eligible sources will be 2x as common.",
                "Farming ticks will occur every minute instead of every five minutes.",
                "Minigame points received are boosted by 4x.",
                "Run energy is never drained whilst running.",
                "All clue scrolls will drop as stackable scroll boxes, and clue step progress is saved between clues."
            ),
            NavCard("Endless Harvest", "Resources are auto-banked and can be gathered indefinitely with a 2x multiplier.", EndlessHarvestView::class.java,
                "$RELICS_IMG/endless-harvest.png"),
            NavCard("Barbarian Gathering", "Gather with bare hands at crystal tool speed using a knapsack.", BarbarianGatheringView::class.java,
                "$RELICS_IMG/barbarian-gathering.png"),
            NavCard("Abundance", "Non-combat skills boosted by 10 with bonus XP and coins per action.", AbundanceView::class.java,
                "$RELICS_IMG/abundance.png")
        )
        addTierSection("Tier 2",
            passive = listOf("Leagues XP multiplier is increased from 5x to 8x."),
            NavCard("Hotfoot", "Auto-cook fish and smelt ore; gain Agility XP while running in searing boots.", HotfootView::class.java,
                "$RELICS_IMG/hotfoot.png"),
            NavCard("Friendly Forager", "Forager's pouch finds herbs while skilling; 90% chance to not consume herblore secondaries.", FriendlyForagerView::class.java,
                "$RELICS_IMG/friendly-forager.png"),
            NavCard("Woodsman", "Hunter loot auto-banks; logs auto-burn; 100% hunter success with doubled loot.", WoodsmanView::class.java,
                "$RELICS_IMG/woodsman.png")
        )
        addTierSection("Tier 3",
            passive = listOf(
                "Combat experience (Including Hitpoints and Prayer) will be multiplied by 1.5x.",
                "The Bigger and Badder Slayer unlock is unlocked for free.",
                "Slayer reward points are 5x from tasks, and you aren't required to complete 5 tasks before earning points.",
                "Superior Slayer monsters will appear at a rate of 1/50."
            ),
            NavCard("Evil Eye", "Teleport directly to any boss or raid entrance from your combat achievements list.", EvilEyeView::class.java,
                "$RELICS_IMG/evil-eye.png"),
            NavCard("Map of Alacrity", "Teleport to agility shortcuts while keeping their level requirements.", MapOfAlacrityView::class.java,
                "$RELICS_IMG/map-of-alacrity.png")
        )
        addTierSection("Tier 4",
            passive = listOf(
                "Items from eligible sources will be 5x as common.",
                "Minigame Points received are boosted by 8x."
            ),
            NavCard("Transmutation", "Transform resources between tiers using alchemic spells with nature runes.", TransmutationView::class.java,
                "$RELICS_IMG/transmutation.png"),
            NavCard("Conniving Clues", "1 in 3 chance for clue contracts from caskets with a guaranteed minimum step count.", ConnivingCluesView::class.java,
                "$RELICS_IMG/conniving-clues.png"),
            NavCard("Butler's Bell", "Summon a demon butler to gather and process resources for you offline.", ButlersBellView::class.java,
                "$RELICS_IMG/butlers-bell.png")
        )
        addTierSection("Tier 5",
            passive = listOf("Leagues XP multiplier is increased from 8x to 12x."),
            NavCard("Nature's Accord", "No farming level requirements; 10x crop yield; crops never die.", NaturesAccordView::class.java,
                "$RELICS_IMG/natures-accord.png"),
            NavCard("Larcenist", "100% thieving success rate; stolen items are automatically noted.", LarcenistView::class.java,
                "$RELICS_IMG/larcenist.png"),
            NavCard("Soul Harvest", "Bones and ashes become soul shards usable for Runecraft or Prayer.", SoulHarvestView::class.java,
                "$RELICS_IMG/soul-harvest.png")
        )
        addTierSection("Tier 6",
            passive = null,
            NavCard("Grimoire", "Freely swap spellbooks and unlock all prayers and spells without requirements.", GrimoireView::class.java,
                "$RELICS_IMG/grimoire.png"),
            NavCard("Culling Spree", "Pick slayer tasks from three options and choose your own kill count.", CullingSpreeView::class.java,
                "$RELICS_IMG/culling-spree.png")
        )
        addTierSection("Tier 7",
            passive = listOf("Leagues XP multiplier is increased from 12x to 16x."),
            NavCard("Reloaded", "Select an additional relic from any tier below this one.", ReloadedView::class.java,
                "$RELICS_IMG/reloaded.png")
        )
        addTierSection("Tier 8",
            passive = null,
            NavCard("Minion", "Summon a powerful combat minion to fight by your side for 30 minutes.", MinionView::class.java,
                "$RELICS_IMG/minion.png"),
            NavCard("Flask of Fervour", "Restore HP, Prayer, and special attack; deal typeless damage every 3 minutes.", FlaskOfFervourView::class.java,
                "$RELICS_IMG/flask-of-fervour.png")
        )
    }

    private fun addTierSection(tier: String, passive: List<String>?, vararg cards: NavCard) {
        add(VerticalLayout().apply {
            addClassName("tier-section")
            isPadding = false
            add(H3(tier))
            if (passive != null) {
                add(Div().apply {
                    addClassName("tier-passive-banner")
                    add(UnorderedList(*passive.map { ListItem(it) }.toTypedArray()))
                })
            }
            add(FlexLayout(*cards).apply {
                addClassName("nav-card-grid")
            })
        })
    }
}
