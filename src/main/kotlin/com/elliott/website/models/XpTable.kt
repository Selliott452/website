package com.elliott.website.models

import kotlin.math.floor
import kotlin.math.pow

object XpTable {
    private val xpForLevel: LongArray = LongArray(100).also { table ->
        table[1] = 0L
        var cumulative = 0.0
        for (level in 2..99) {
            cumulative += floor((level - 1).toDouble() + 300.0 * 2.0.pow((level - 1).toDouble() / 7.0)) / 4.0
            table[level] = floor(cumulative).toLong()
        }
    }

    fun xpForLevel(level: Int): Long {
        require(level in 1..99) { "Level must be between 1 and 99" }
        return xpForLevel[level]
    }

}
