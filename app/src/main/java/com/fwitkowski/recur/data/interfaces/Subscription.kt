package com.fwitkowski.recur.data.interfaces

data class Subscription(
    val company: String,
    val subscriptionName: String,
    val price: Float,
    val period: SubscriptionPeriod
)