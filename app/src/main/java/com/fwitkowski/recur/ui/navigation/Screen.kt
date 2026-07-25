package com.fwitkowski.recur.ui.navigation

sealed class Screen(val route: String) {
    data object SubscriptionList : Screen("subscriptionList")

    data object SubscriptionSummary : Screen("subscriptionSummary/{subscriptionIndex}") {
        const val ARG_SUBSCRIPTION_INDEX = "subscriptionIndex"

        fun createRoute(subscriptionIndex: Int) = "subscriptionSummary/$subscriptionIndex"
    }
}
