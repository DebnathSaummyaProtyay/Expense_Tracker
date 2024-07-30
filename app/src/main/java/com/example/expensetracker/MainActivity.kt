package com.example.expensetracker

import Expense
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var totalBudget: Double = 0.0
    private var currentBalance: Double = 0.0
    private val expenses = mutableListOf<Expense>()
    private lateinit var expenseAdapter: ExpenseAdapter

    private lateinit var btnSetBudget: Button
    private lateinit var btnAddExpense: Button
    private lateinit var btnShowExpenses: Button
    private lateinit var btnShowChart: Button
    private lateinit var btnReset: Button
    private lateinit var etBudget: EditText
    private lateinit var etExpenseAmount: EditText
    private lateinit var spCategory: Spinner
    private lateinit var tvBalance: TextView
    private lateinit var lineChartView: LineChartView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetBudget = findViewById(R.id.btnSetBudget)
        btnAddExpense = findViewById(R.id.btnAddExpense)
        btnShowExpenses = findViewById(R.id.btnShowExpenses)
        btnShowChart = findViewById(R.id.btnShowChart)
        btnReset = findViewById(R.id.btnReset)
        etBudget = findViewById(R.id.etBudget)
        etExpenseAmount = findViewById(R.id.etExpenseAmount)
        spCategory = findViewById(R.id.spCategory)
        tvBalance = findViewById(R.id.tvBalance)
        lineChartView = findViewById(R.id.lineChartView)
        recyclerView = findViewById(R.id.recyclerView)

        val categories = listOf("Food", "Transport", "Entertainment", "Utilities", "Others")
        val icons = listOf(R.drawable.ic_food, R.drawable.ic_transport, R.drawable.ic_entertainment, R.drawable.ic_utilities, R.drawable.ic_others)
        spCategory.adapter = CategoryAdapter(this, categories, icons)

        btnSetBudget.setOnClickListener {
            totalBudget = etBudget.text.toString().toDouble()
            currentBalance = totalBudget
            updateBalance(tvBalance)
        }

        btnAddExpense.setOnClickListener {
            val expenseAmount = etExpenseAmount.text.toString().toFloat()
            val expenseCategory = spCategory.selectedItem.toString()
            val expense = Expense(expenseCategory, expenseAmount)
            expenses.add(expense)
            currentBalance -= expenseAmount
            updateBalance(tvBalance)
            expenseAdapter.notifyDataSetChanged()
        }

        btnShowExpenses.setOnClickListener {
            expenseAdapter.notifyDataSetChanged()
        }

        btnShowChart.setOnClickListener {
            val dialog = ExpenseChartDialog.newInstance(expenses)
            dialog.show(supportFragmentManager, "ExpenseChartDialog")
        }

        btnReset.setOnClickListener {
            expenses.clear()
            currentBalance = totalBudget
            updateBalance(tvBalance)
            expenseAdapter.notifyDataSetChanged()
            lineChartView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        expenseAdapter = ExpenseAdapter(expenses)
        recyclerView.adapter = expenseAdapter
    }

    private fun updateBalance(tvBalance: TextView) {
        tvBalance.text = "Balance: $currentBalance"
        if (currentBalance < 0) {
            Toast.makeText(this, "Warning: Balance is negative!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            R.id.action_about -> {
                val aboutDialog = AboutDialogFragment()
                aboutDialog.show(supportFragmentManager, "AboutDialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
