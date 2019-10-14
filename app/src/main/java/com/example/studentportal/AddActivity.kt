package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        btnAdd.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        btnAdd.setOnClickListener { view ->
            if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
                val portal = Portal(etTitle.text.toString(), etUrl.text.toString())
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_PORTAL, portal)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(
                    this, "Please fill in the title/url"
                    , Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
