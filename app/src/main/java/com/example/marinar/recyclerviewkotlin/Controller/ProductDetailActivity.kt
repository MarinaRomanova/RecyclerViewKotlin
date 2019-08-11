package com.example.marinar.recyclerviewkotlin.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.marinar.recyclerviewkotlin.Model.Product
import com.example.marinar.recyclerviewkotlin.R
import com.example.marinar.recyclerviewkotlin.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        detail_image_view.setImageResource(resources.getIdentifier(product.image, "drawable", packageName))
        detail_title_textView.text = product.title
        detail_price_textView.text = product.price
    }

    fun onAddToCart(view: View){
        Toast.makeText(this, "${product.title} added to your cart", Toast.LENGTH_SHORT).show()
    }
}
