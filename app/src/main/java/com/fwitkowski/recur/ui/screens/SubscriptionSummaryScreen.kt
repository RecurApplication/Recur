package com.fwitkowski.recur.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fwitkowski.recur.R
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.data.model.renewalProgressRemaining
import com.fwitkowski.recur.ui.components.RenewalGauge
import com.fwitkowski.recur.ui.components.labelRes
import com.fwitkowski.recur.ui.theme.categoryColors
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionSummaryScreen(
    subscription: Subscription,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scheme = categoryColors(subscription.category)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.subscription_summary_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.subscription_summary_back),
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            RenewalGauge(
                progress = subscription.renewalProgressRemaining(),
                diameter = 120.dp,
                strokeWidth = 12.dp,
                progressColor = scheme.gaugeColor,
            )
            Text(
                text = subscription.subscriptionName,
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = subscription.company,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = "${subscription.price} zł • ${stringResource(subscription.period.labelRes)}",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "${stringResource(R.string.subscription_summary_next_renewal)}: " +
                    subscription.renewalDate.format(DateTimeFormatter.ISO_DATE),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
