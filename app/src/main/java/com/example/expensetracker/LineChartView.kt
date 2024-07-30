package com.example.expensetracker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineChartView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()
    private val axisPaint = Paint().apply { color = Color.BLACK; strokeWidth = 5f }
    private val textPaint = Paint().apply { color = Color.BLACK; textSize = 30f }

    var data: List<Float> = listOf()
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (data.isEmpty()) return

        val maxDataValue = data.maxOrNull() ?: 1f
        val minDataValue = data.minOrNull() ?: 0f
        val dataRange = maxDataValue - minDataValue
        val chartHeight = height - 2 * paddingTop
        val chartWidth = width - 2 * paddingLeft

        // Draw X and Y axes
        canvas.drawLine(paddingLeft.toFloat(), height - paddingTop.toFloat(), width - paddingRight.toFloat(), height - paddingTop.toFloat(), axisPaint)
        canvas.drawLine(paddingLeft.toFloat(), paddingTop.toFloat(), paddingLeft.toFloat(), height - paddingTop.toFloat(), axisPaint)

        // Draw the line chart
        paint.color = Color.GREEN
        paint.strokeWidth = 5f
        val pointWidth = chartWidth.toFloat() / (data.size - 1)
        for (i in 0 until data.size - 1) {
            val startX = paddingLeft + i * pointWidth
            val startY = height - paddingTop - ((data[i] - minDataValue) / dataRange) * chartHeight
            val endX = paddingLeft + (i + 1) * pointWidth
            val endY = height - paddingTop - ((data[i + 1] - minDataValue) / dataRange) * chartHeight
            canvas.drawLine(startX, startY, endX, endY, paint)
        }

        // Draw data points
        paint.color = Color.RED
        for (i in data.indices) {
            val x = paddingLeft + i * pointWidth
            val y = height - paddingTop - ((data[i] - minDataValue) / dataRange) * chartHeight
            canvas.drawCircle(x, y, 10f, paint)
            canvas.drawText(data[i].toString(), x - 20, y - 20, textPaint)
        }
    }
}
