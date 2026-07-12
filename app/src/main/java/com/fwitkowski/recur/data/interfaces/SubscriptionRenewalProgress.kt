package com.fwitkowski.recur.data.interfaces

import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun Subscription.renewalProgressRemaining(today: LocalDate = LocalDate.now()): Float {
    val cycleStart = renewalDate.minus(period.nominalCycleLength)
    val totalDays = ChronoUnit.DAYS.between(cycleStart, renewalDate)
    if (totalDays <= 0L) return 0f

    val elapsedDays = ChronoUnit.DAYS.between(cycleStart, today)
    val elapsedFraction = elapsedDays.toDouble() / totalDays.toDouble()
    return (1.0 - elapsedFraction).toFloat().coerceIn(0f, 1f)
}
