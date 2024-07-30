package com.example.expensetracker

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.preference.PreferenceFragmentCompat

class SettingsDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?) = activity?.let {
        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(it)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_settings, null)

        builder.setView(view)
            .setPositiveButton(android.R.string.ok) { dialog, id ->
                // User clicked OK button
            }
            .setNegativeButton(android.R.string.cancel) { dialog, id ->
                // User cancelled the dialog
                dialog.cancel()
            }

        builder.create()
    } ?: throw IllegalStateException("Activity cannot be null")

    class SettingsPreferenceFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferences, rootKey)
        }
    }
}
