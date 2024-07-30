package com.example.expensetracker

import Expense
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val expenses: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(expenses[position])
    }

    override fun getItemCount(): Int = expenses.size

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvExpenseCategory: TextView = itemView.findViewById(R.id.tvExpenseCategory)
        private val tvExpenseAmount: TextView = itemView.findViewById(R.id.tvExpenseAmount)

        fun bind(expense: Expense) {
            tvExpenseCategory.text = expense.category
            tvExpenseAmount.text = expense.amount.toString()
        }
    }
}
