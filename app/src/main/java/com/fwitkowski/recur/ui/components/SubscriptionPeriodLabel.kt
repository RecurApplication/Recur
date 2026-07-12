package com.fwitkowski.recur.ui.components

import androidx.annotation.StringRes
import com.fwitkowski.recur.R
import com.fwitkowski.recur.data.model.SubscriptionPeriod

val SubscriptionPeriod.labelRes: Int
    @StringRes get() = when (this) {
        SubscriptionPeriod.DAY -> R.string.renewal_period_daily
        SubscriptionPeriod.WEEK -> R.string.renewal_period_weekly
        SubscriptionPeriod.MONTH -> R.string.renewal_period_monthly
        SubscriptionPeriod.CALENDAR_MONTH -> R.string.renewal_period_calendar_month
        SubscriptionPeriod.QUARTER -> R.string.renewal_period_quarterly
        SubscriptionPeriod.YEAR -> R.string.renewal_period_yearly
        SubscriptionPeriod.NONSTANDARD -> R.string.renewal_period_onceoff
    }
