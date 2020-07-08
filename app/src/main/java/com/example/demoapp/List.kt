package com.example.demoapp

import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class List : AppCompatActivity() {

    var array = arrayOf(
        "Let Us C",
        "c++",
        "JAVA",
        "Jsp",
        "Microsoft .Net",
        "Android",
        "PHP",
        "Jquery",
        "JavaScript"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_list)

        val adapter = ArrayAdapter(this, R.layout.listview_item, array)

        val listView: ListView = findViewById(R.id.list_view)

        listView.adapter = adapter
    }
}
