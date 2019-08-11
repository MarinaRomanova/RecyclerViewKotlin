package com.example.marinar.recyclerviewkotlin.Controller

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.marinar.recyclerviewkotlin.Adapters.ProductsRecyclerAdapter
import com.example.marinar.recyclerviewkotlin.R
import com.example.marinar.recyclerviewkotlin.Services.DataService
import com.example.marinar.recyclerviewkotlin.Utilities.EXTRA_CATEGORY
import com.example.marinar.recyclerviewkotlin.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var productAdapter: ProductsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        productAdapter = ProductsRecyclerAdapter(this, DataService.getProducts(categoryType)){ product ->
            val productDetailIntent = Intent(this, ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)
        }

        productsListView.adapter = productAdapter
        val orientation = resources.configuration.orientation
        var spanCount = 2
        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount++
        }
        val layoutManager = GridLayoutManager(this, spanCount)

        productsListView.layoutManager = layoutManager

        productsListView.setHasFixedSize(true)

    }
}
