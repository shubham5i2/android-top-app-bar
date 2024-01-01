package com.sks.topappbar

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var showSnackbarMessage: Button
    private lateinit var myLayout: ConstraintLayout
    private lateinit var showDialogMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        showSnackbarMessage = findViewById(R.id.buttonSnackbar)
        myLayout = findViewById(R.id.layout)
        showDialogMessage = findViewById(R.id.buttonDialog)

        showSnackbarMessage.setOnClickListener {
            Snackbar.make(myLayout, "This is snackbar alert", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", View.OnClickListener {
                    //some logic
                    Toast.makeText(applicationContext, "Close clicked", Toast.LENGTH_SHORT).show()
                }).show()
        }

        showDialogMessage.setOnClickListener {
            showDialog()
        }

        //get toolbar overflow icon from drawable folder
        toolbar.overflowIcon =
            AppCompatResources.getDrawable(this, R.drawable.baseline_more_vert_24)

        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext, "Navigation icon is clicked", Toast.LENGTH_SHORT)
                .show()
        }

        toolbar.setOnMenuItemClickListener { item ->

            when (item.itemId) {
                R.id.share -> Toast.makeText(
                    applicationContext, "Share icon is clicked", Toast.LENGTH_SHORT
                ).show()

                R.id.edit -> Toast.makeText(
                    applicationContext, "Edit icon is clicked", Toast.LENGTH_SHORT
                ).show()

                R.id.favourite -> Toast.makeText(
                    applicationContext, "Favourite icon is clicked", Toast.LENGTH_SHORT
                ).show()

                R.id.settings -> Toast.makeText(
                    applicationContext, "Settings icon is clicked", Toast.LENGTH_SHORT
                ).show()

                else -> Toast.makeText(
                    applicationContext, "Sign Out icon is clicked", Toast.LENGTH_SHORT
                ).show()
            }

            return@setOnMenuItemClickListener true
        }
    }

    private fun showDialog() {
        //Here, an instance of AlertDialog.Builder is created. The AlertDialog.Builder class is used to construct an AlertDialog.
        val alertDialog = AlertDialog.Builder(this@MainActivity)

        alertDialog.setTitle("Change")
            .setMessage("Do you want to change the text of the button?")
            .setIcon(R.drawable.round_warning_24)
            .setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                showDialogMessage.text = "Alert Dialog"
            })
            .create()
            .show()
    }
}