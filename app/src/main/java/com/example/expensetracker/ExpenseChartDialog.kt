package com.example.expensetracker

import Expense
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class ExpenseChartDialog(private val expenses: List<Expense>) : DialogFragment() {

    companion object {
        fun newInstance(expenses: List<Expense>): ExpenseChartDialog {
            return ExpenseChartDialog(expenses)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_expense_chart, container, false)
        val chartContainer: LinearLayout = view.findViewById(R.id.chartContainer)

        val totalAmount = expenses.sumOf { it.amount.toDouble() }
        for (expense in expenses.groupBy { it.category }) {
            val percentage = (expense.value.sumOf { it.amount.toDouble() } / totalAmount) * 100
            val textView = TextView(context).apply {
                text = "${expense.key}: ${String.format("%.2f", percentage)}%"
            }
            chartContainer.addView(textView)
        }

        return view
    }
}
