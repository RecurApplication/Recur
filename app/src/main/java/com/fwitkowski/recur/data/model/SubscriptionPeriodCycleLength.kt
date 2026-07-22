package com.fwitkowski.recur.data.model

import java.time.Period

val SubscriptionPeriod.nominalCycleLength: Period
    get() = when (this) {
        SubscriptionPeriod.DAY -> Period.ofDays(1)
        SubscriptionPeriod.WEEK -> Period.ofDays(7)
        SubscriptionPeriod.MONTH -> Period.ofDays(30)
        SubscriptionPeriod.CALENDAR_MONTH -> Period.ofMonths(1)
        SubscriptionPeriod.QUARTER -> Period.ofMonths(3)
        SubscriptionPeriod.YEAR -> Period.ofYears(1)
        SubscriptionPeriod.NONSTANDARD -> Period.ofDays(30)
    }
