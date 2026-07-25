package com.fwitkowski.recur.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.ui.components.SubscriptionTile

@Composable
fun SubscriptionListScreen(
    subscriptions: List<Subscription>,
    onSubscriptionClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(subscriptions.size) { index ->
            SubscriptionTile(
                subscription = subscriptions[index],
                onClick = { onSubscriptionClick(index) },
            )
        }
    }
}
