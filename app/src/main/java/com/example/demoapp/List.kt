package com.example.demoapp

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*

class List : AppCompatActivity() {

    lateinit var items: ArrayList<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_list)

        val rvItems = findViewById<View>(R.id.rv_items) as RecyclerView
        items = Items.createItems(20)
        val adapter = ItemsAdapter(items)
        rv_items.adapter = adapter
        rv_items.layoutManager = LinearLayoutManager(this)
    }
}
