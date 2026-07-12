package com.fwitkowski.recur.data.interfaces

import java.time.LocalDate

data class Subscription(
    val company: String,
    val subscriptionName: String,
    val price: Float,
    val period: SubscriptionPeriod,
    val renewalDate: LocalDate,
)