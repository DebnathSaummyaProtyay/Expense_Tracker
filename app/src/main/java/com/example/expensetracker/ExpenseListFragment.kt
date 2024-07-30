package com.example.expensetracker

import Expense
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpenseListFragment : Fragment() {
    private lateinit var expenses: List<Expense>

    companion object {
        private const val ARG_EXPENSES = "expenses"

        fun newInstance(expenses: List<Expense>): ExpenseListFragment {
            val fragment = ExpenseListFragment()
            val args = Bundle()
            args.putSerializable(ARG_EXPENSES, ArrayList(expenses))
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            expenses = it.getSerializable(ARG_EXPENSES) as List<Expense>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_expense_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ExpenseAdapter(expenses)
        return view
    }
}
