package com.example.rcrespillo.searchml

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SearchML : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ml)

        val btn_search = findViewById<Button>(R.id.searchButton)
        val btn_clean = findViewById<Button>(R.id.cleanButton)
        val txt_search = findViewById<EditText>(R.id.searchText)

        btn_search.setOnClickListener{
            val intent = Intent(this, SearchListML::class.java)
            intent.putExtra("searchText", txt_search.text.toString())
            startActivity(intent)
        }

        btn_clean.setOnClickListener{
            txt_search.setText("")
            txt_search.requestFocus()
        }
    }
}
