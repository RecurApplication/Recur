package com.fwitkowski.recur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.data.model.SubscriptionCategory
import com.fwitkowski.recur.data.model.SubscriptionPeriod
import com.fwitkowski.recur.ui.navigation.RecurNavHost
import com.fwitkowski.recur.ui.theme.RecurTheme
import java.time.LocalDate

private val demoSubscriptions = listOf(
    Subscription(
        company = "OpenAI",
        subscriptionName = "ChatGPT Plus",
        price = 99.99f,
        period = SubscriptionPeriod.CALENDAR_MONTH,
        renewalDate = LocalDate.now().plusDays(15),
        category = SubscriptionCategory.AI
    ),
    Subscription(
        company = "Spotify",
        subscriptionName = "Premium",
        price = 29.99f,
        period = SubscriptionPeriod.MONTH,
        renewalDate = LocalDate.now().plusDays(10),
        category = SubscriptionCategory.MUSIC
    ),
    Subscription(
        company = "Netflix",
        subscriptionName = "Standard",
        price = 55.0f,
        period = SubscriptionPeriod.MONTH,
        renewalDate = LocalDate.now().plusDays(3),
        category = SubscriptionCategory.VIDEO
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecurTheme {
                RecurNavHost(
                    subscriptions = demoSubscriptions,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}