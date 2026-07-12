package com.fwitkowski.recur.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private const val GAUGE_START_ANGLE = 135f
private const val GAUGE_SWEEP_ANGLE = 270f

@Composable
fun RenewalGauge(
    progress: Float,
    modifier: Modifier = Modifier,
    diameter: Dp = 48.dp,
    strokeWidth: Dp = 6.dp,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    progressColor: Color = MaterialTheme.colorScheme.primary,
) {
    val clamped = progress.coerceIn(0f, 1f)
    Canvas(modifier = modifier.size(diameter)) {
        val strokeWidthPx = strokeWidth.toPx()
        val arcSize = Size(size.width - strokeWidthPx, size.height - strokeWidthPx)
        val topLeft = Offset(strokeWidthPx / 2f, strokeWidthPx / 2f)
        val stroke = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)

        drawArc(
            color = trackColor,
            startAngle = GAUGE_START_ANGLE,
            sweepAngle = GAUGE_SWEEP_ANGLE,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = stroke,
        )

        if (clamped > 0f) {
            drawArc(
                color = progressColor,
                startAngle = GAUGE_START_ANGLE,
                sweepAngle = GAUGE_SWEEP_ANGLE * clamped,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = stroke,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RenewalGaugePreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        RenewalGauge(progress = 0f)
        RenewalGauge(progress = 0.5f)
        RenewalGauge(progress = 0.9f)
        RenewalGauge(progress = 1f)
    }
}
