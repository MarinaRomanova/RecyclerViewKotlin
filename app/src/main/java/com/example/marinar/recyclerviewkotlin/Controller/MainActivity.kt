package com.example.marinar.recyclerviewkotlin.Controller

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.marinar.recyclerviewkotlin.Adapters.CategoryRecyclerAdapter
import com.example.marinar.recyclerviewkotlin.R
import com.example.marinar.recyclerviewkotlin.Services.DataService
import com.example.marinar.recyclerviewkotlin.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.name)
            startActivity(productIntent)
        }

        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true) //for optimization
    }
}
