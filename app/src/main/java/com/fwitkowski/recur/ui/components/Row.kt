package com.fwitkowski.recur.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.data.model.SubscriptionCategory
import com.fwitkowski.recur.data.model.SubscriptionPeriod
import com.fwitkowski.recur.data.model.renewalProgressRemaining
import com.fwitkowski.recur.ui.theme.categoryColors
import java.time.LocalDate

@Composable
fun SubscriptionTile(
    subscription: Subscription,
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    gaugeColor: Color? = null,
    onClick: (() -> Unit)? = null,
) {
    val scheme = categoryColors(subscription.category)
    val resolvedGaugeColor = gaugeColor ?: scheme.gaugeColor
    val cardColors = CardDefaults.cardColors(containerColor = backgroundColor ?: scheme.backgroundColor)
    val cardShape = RoundedCornerShape(16.dp)
    val cardElevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    val cardModifier = modifier.fillMaxWidth().padding(16.dp)

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = cardModifier,
            shape = cardShape,
            elevation = cardElevation,
            colors = cardColors,
        ) {
            SubscriptionTileContent(subscription, resolvedGaugeColor)
        }
    } else {
        Card(
            modifier = cardModifier,
            shape = cardShape,
            elevation = cardElevation,
            colors = cardColors,
        ) {
            SubscriptionTileContent(subscription, resolvedGaugeColor)
        }
    }
}

@Composable
private fun SubscriptionTileContent(subscription: Subscription, gaugeColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        RenewalGauge(
            progress = subscription.renewalProgressRemaining(),
            progressColor = gaugeColor
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = subscription.subscriptionName,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = subscription.company,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "${subscription.price} zł",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(subscription.period.labelRes),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SubscriptionTileExample() {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        SubscriptionTile(
            Subscription(
                company = "Anthropic",
                subscriptionName = "Claude Pro",
                price = 99.99f,
                period = SubscriptionPeriod.MONTH,
                renewalDate = LocalDate.now().plusMonths(1),
                category = SubscriptionCategory.AI
            )
        )
        SubscriptionTile(
            Subscription(
                company = "Spotify",
                subscriptionName = "Premium",
                price = 29.99f,
                period = SubscriptionPeriod.MONTH,
                renewalDate = LocalDate.now().plusDays(10),
                category = SubscriptionCategory.MUSIC
            )
        )
        SubscriptionTile(
            Subscription(
                company = "Netflix",
                subscriptionName = "Standard",
                price = 55.0f,
                period = SubscriptionPeriod.MONTH,
                renewalDate = LocalDate.now().plusDays(3),
                category = SubscriptionCategory.VIDEO
            )
        )
    }
}

