package com.fwitkowski.recur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fwitkowski.recur.data.interfaces.Subscription
import com.fwitkowski.recur.data.interfaces.SubscriptionPeriod
import com.fwitkowski.recur.ui.components.SubscriptionTile
import com.fwitkowski.recur.ui.theme.RecurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SubscriptionTile(
                        Subscription(
                            company = "OpenAI",
                            subscriptionName = "ChatGPT Plus",
                            price = 99.99f,
                            period = SubscriptionPeriod.CALENDAR_MONTH
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecurTheme {
    }
}