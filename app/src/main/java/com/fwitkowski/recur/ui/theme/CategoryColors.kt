package com.fwitkowski.recur.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.toArgb
import com.fwitkowski.recur.data.model.SubscriptionCategory
import com.google.android.material.color.MaterialColors

private val SubscriptionCategory.seedColor: Color
    get() = when (this) {
        SubscriptionCategory.AI -> Color(0xFF6750A4)
        SubscriptionCategory.VIDEO -> Color(0xFFE0413A)
        SubscriptionCategory.MUSIC -> Color(0xFFE07A2A)
        SubscriptionCategory.PHONE -> Color(0xFF3E9A56)
        SubscriptionCategory.APP -> Color(0xFF1B8B7E)
        SubscriptionCategory.CUSTOM -> Color(0xFF2A6CB8)
        SubscriptionCategory.MONEY -> Color(0xFF6E4FA0)
        SubscriptionCategory.GAMES -> Color(0xFFCE4F8E)
        SubscriptionCategory.BILL -> Color(0xFF8A6D3B)
        SubscriptionCategory.CAR -> Color(0xFF4A6B7A)
    }

data class CategoryColorScheme(
    val gaugeColor: Color,
    val backgroundColor: Color,
)

@Composable
@ReadOnlyComposable
fun categoryColors(category: SubscriptionCategory): CategoryColorScheme {
    val harmonized = Color(
        MaterialColors.harmonize(
            category.seedColor.toArgb(),
            MaterialTheme.colorScheme.primary.toArgb(),
        )
    )
    val background = harmonized
        .copy(alpha = 0.15f)
        .compositeOver(MaterialTheme.colorScheme.surfaceContainerHighest)
    return CategoryColorScheme(
        gaugeColor = harmonized,
        backgroundColor = background,
    )
}
