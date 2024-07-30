package com.example.expensetracker

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AboutDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("About")
            .setMessage("Expense Tracker App\nVersion 1.0")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
    }
}
