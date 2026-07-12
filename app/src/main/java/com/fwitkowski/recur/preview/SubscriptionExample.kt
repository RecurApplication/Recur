package com.fwitkowski.recur.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.fwitkowski.recur.data.model.Subscription
import com.fwitkowski.recur.data.model.SubscriptionCategory
import com.fwitkowski.recur.data.model.SubscriptionPeriod
import java.time.LocalDate

class SubscriptionPreviewParameterProvider : PreviewParameterProvider<Subscription> {
    override val values = sequenceOf(
        Subscription(
            company = "Anthropic",
            subscriptionName = "Claude Pro",
            price = 90f,
            period = SubscriptionPeriod.MONTH,
            renewalDate = LocalDate.now().plusMonths(1),
            category = SubscriptionCategory.AI
        )
    )
}

