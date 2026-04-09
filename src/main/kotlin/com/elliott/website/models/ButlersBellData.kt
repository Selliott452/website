package com.elliott.website.models

enum class ResourceCategory(
    val displayName: String,
    val gatherRatePerMin: Double
) {
    FISH("Fish", 14.0),
    FLAX("Flax", 50.0),
    HERBS("Herbs", 10.0),
    ORE("Ore", 8.0),
    WOOD("Wood", 10.0)
}

data class ButlersBellItem(
    val rawName: String,
    val processedName: String,
    val dropRate: Double
) {

    fun rawImageUrl(): String = "$WIKI_IMAGE_BASE${rawName.replace(' ', '_')}.png"
    fun processedImageUrl(): String = "$WIKI_IMAGE_BASE${processedName.replace(' ', '_')}.png"

    companion object {
        const val BASE_PROCESS_XP = 10.0
        private const val WIKI_IMAGE_BASE = "https://oldschool.runescape.wiki/images/"
    }
}

object ButlersBellData {

    val XP_MULTIPLIERS = listOf(5, 8, 12, 16)

    val ALL_BY_CATEGORY: Map<ResourceCategory, List<ButlersBellItem>> = mapOf(
        ResourceCategory.FISH to listOf(
            ButlersBellItem("Raw salmon", "Salmon", 0.26),
            ButlersBellItem("Raw tuna", "Tuna", 0.21),
            ButlersBellItem("Raw lobster", "Lobster", 0.18),
            ButlersBellItem("Raw swordfish", "Swordfish", 0.135),
            ButlersBellItem("Raw monkfish", "Monkfish", 0.095),
            ButlersBellItem("Raw shark", "Shark", 0.08),
            ButlersBellItem("Raw manta ray", "Manta ray", 0.025),
            ButlersBellItem("Raw anglerfish", "Anglerfish", 0.015),
        ),
        ResourceCategory.FLAX to listOf(
            ButlersBellItem("Flax", "Bow string", 1.0),
        ),
        ResourceCategory.HERBS to listOf(
            ButlersBellItem("Grimy tarromin", "Tarromin potion (unf)", 0.217),
            ButlersBellItem("Grimy harralander", "Harralander potion (unf)", 0.196),
            ButlersBellItem("Grimy ranarr weed", "Ranarr potion (unf)", 0.065),
            ButlersBellItem("Grimy irit leaf", "Irit potion (unf)", 0.130),
            ButlersBellItem("Grimy avantoe", "Avantoe potion (unf)", 0.130),
            ButlersBellItem("Grimy kwuarm", "Kwuarm potion (unf)", 0.065),
            ButlersBellItem("Grimy cadantine", "Cadantine potion (unf)", 0.065),
            ButlersBellItem("Grimy lantadyme", "Lantadyme potion (unf)", 0.065),
            ButlersBellItem("Grimy dwarf weed", "Dwarf weed potion (unf)", 0.067),
        ),
        ResourceCategory.ORE to listOf(
            ButlersBellItem("Clay", "Soft clay", 0.06),
            ButlersBellItem("Iron ore", "Iron bar", 0.50),
            ButlersBellItem("Mithril ore", "Mithril bar", 0.30),
            ButlersBellItem("Adamantite ore", "Adamantite bar", 0.10),
            ButlersBellItem("Runite ore", "Runite bar", 0.04),
        ),
        ResourceCategory.WOOD to listOf(
            ButlersBellItem("Logs", "Plank", 0.20),
            ButlersBellItem("Oak logs", "Oak plank", 0.30),
            ButlersBellItem("Teak logs", "Teak plank", 0.40),
            ButlersBellItem("Mahogany logs", "Mahogany plank", 0.10),
        )
    )
}
