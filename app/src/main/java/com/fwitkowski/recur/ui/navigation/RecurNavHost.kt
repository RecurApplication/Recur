package com.fwitkowski.recur.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.ui.screens.SubscriptionListScreen
import com.fwitkowski.recur.ui.screens.SubscriptionSummaryScreen

@Composable
fun RecurNavHost(
    subscriptions: List<Subscription>,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SubscriptionList.route,
        modifier = modifier,
    ) {
        composable(Screen.SubscriptionList.route) {
            SubscriptionListScreen(
                subscriptions = subscriptions,
                onSubscriptionClick = { index ->
                    navController.navigate(Screen.SubscriptionSummary.createRoute(index))
                },
            )
        }
        composable(
            route = Screen.SubscriptionSummary.route,
            arguments = listOf(
                navArgument(Screen.SubscriptionSummary.ARG_SUBSCRIPTION_INDEX) {
                    type = NavType.IntType
                }
            ),
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt(Screen.SubscriptionSummary.ARG_SUBSCRIPTION_INDEX) ?: 0
            SubscriptionSummaryScreen(
                subscription = subscriptions[index],
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}
