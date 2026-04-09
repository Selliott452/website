package com.elliott.website.services

import com.elliott.website.models.ButlersBellData
import com.elliott.website.models.ButlersBellItem
import com.elliott.website.models.ResourceCategory
import com.elliott.website.models.XpTable

data class ItemResult(
    val item: ButlersBellItem,
    val gatherPerHour: Double,
    val totalGathered: Double,
    val processPerHour: Double,
    val totalProcessed: Double,
    val xpPerHour: Double,
    val totalXp: Double
)

data class CategoryResult(val items: List<ItemResult>) {
    val totalGatherPerHour get() = items.sumOf { it.gatherPerHour }
    val totalGathered get() = items.sumOf { it.totalGathered }
    val totalProcessPerHour get() = items.sumOf { it.processPerHour }
    val totalProcessed get() = items.sumOf { it.totalProcessed }
    val totalXpPerHour get() = items.sumOf { it.xpPerHour }
    val totalXp get() = items.sumOf { it.totalXp }
}

data class TimeToLevelResult(
    val xpNeeded: Long,
    val xpPerHour: Double,
    val hoursNeeded: Double,
    val breakdown: CategoryResult
)

class ButlersBellCalculator {

    fun calculateCategory(
        category: ResourceCategory,
        hours: Double,
        multiplier: Int,
        includeProcessing: Boolean
    ): CategoryResult {
        val items = ButlersBellData.ALL_BY_CATEGORY[category] ?: emptyList()
        return calculateItems(items, category, hours, multiplier, includeProcessing)
    }

    fun calculateTimeToLevel(
        category: ResourceCategory,
        multiplier: Int,
        currentLevel: Int,
        targetLevel: Int
    ): TimeToLevelResult? {
        if (targetLevel <= currentLevel) return null

        val xpNeeded = XpTable.xpForLevel(targetLevel) - XpTable.xpForLevel(currentLevel)
        val items = ButlersBellData.ALL_BY_CATEGORY[category] ?: emptyList()
        val xpPerHour = items.sumOf { it.dropRate } *
                category.gatherRatePerMin * 30.0 * ButlersBellItem.BASE_PROCESS_XP * multiplier

        if (xpPerHour <= 0) return null

        val hoursNeeded = xpNeeded.toDouble() / xpPerHour
        return TimeToLevelResult(
            xpNeeded = xpNeeded,
            xpPerHour = xpPerHour,
            hoursNeeded = hoursNeeded,
            breakdown = calculateItems(items, category, hoursNeeded, multiplier, true)
        )
    }

    fun formatDuration(totalMinutes: Double): String {
        val days = (totalMinutes / 1440).toInt()
        val hours = ((totalMinutes % 1440) / 60).toInt()
        val minutes = (totalMinutes % 60).toInt()
        return buildString {
            if (days > 0) append("${days}d ")
            if (hours > 0 || days > 0) append("${hours}h ")
            append("${minutes}m")
        }.trim()
    }

    private fun calculateItems(
        items: List<ButlersBellItem>,
        category: ResourceCategory,
        hours: Double,
        multiplier: Int,
        includeProcessing: Boolean
    ): CategoryResult {
        val gatherRate = category.gatherRatePerMin * 60.0
        return CategoryResult(items.map { item ->
            val gatherHr = gatherRate * item.dropRate
            val procHr = if (includeProcessing) gatherHr / 2.0 else 0.0
            val xpHr = procHr * ButlersBellItem.BASE_PROCESS_XP * multiplier
            ItemResult(
                item = item,
                gatherPerHour = gatherHr,
                totalGathered = gatherHr * hours,
                processPerHour = procHr,
                totalProcessed = procHr * hours,
                xpPerHour = xpHr,
                totalXp = xpHr * hours
            )
        })
    }
}
