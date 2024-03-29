package com.example.marinar.recyclerviewkotlin.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.marinar.recyclerviewkotlin.Model.Product
import com.example.marinar.recyclerviewkotlin.R

class ProductsRecyclerAdapter(val context:Context, val products: List<Product>, val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductsRecyclerAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(productHolder: ProductHolder, position: Int) {
        productHolder.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View, val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView){
        val productImageView = itemView.findViewById<ImageView>(R.id.productImageView)
        val productTitleTextView = itemView.findViewById<TextView>(R.id.product_title_tv)
        val productPriceTextView = itemView.findViewById<TextView>(R.id.product_price_tv)

        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImageView.setImageResource(resourceId)
            productTitleTextView.text = product.title
            productPriceTextView.text = product.price
            itemView.setOnClickListener {itemClick(product)}
        }

    }

}