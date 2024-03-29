package com.example.marinar.recyclerviewkotlin.Services

import com.example.marinar.recyclerviewkotlin.Model.Category
import com.example.marinar.recyclerviewkotlin.Model.Product

object DataService {

    val categories = listOf(
            Category("SHIRTS", "shirtimage"),
            Category("HOODIES", "hoodieimage"),
            Category("HATS", "hatimage"),
            Category("DIGITAL", "digitalgoodsimage")
    )

    private val hats = listOf(
            Product("Devslopes Graphic Beenie", "$18", "hat1"),
            Product("Devslopes Hat Black", "$20", "hat2"),
            Product("Devslopes Hat White", "$18", "hat3"),
            Product("Devslopes Snap Back", "$22", "hat4"),
            Product("Devslopes Graphic Beenie", "$18", "hat1"),
            Product("Devslopes Hat Black", "$20", "hat2"),
            Product("Devslopes Hat White", "$18", "hat3"),
            Product("Devslopes Snap Back", "$22", "hat4")
    )

    private val hoodies = listOf(
            Product("Devslopes Hoodie Gray", "$28", "hoodie1"),
            Product("Devslopes Hoodie Red", "$32", "hoodie2"),
            Product("Devslopes Gray hoodie", "$28", "hoodie3"),
            Product("Devslopes Black Hoodie", "$32", "hoodie4"),
            Product("Devslopes Hoodie Gray", "$28", "hoodie1"),
            Product("Devslopes Hoodie Red", "$32", "hoodie2"),
            Product("Devslopes Gray hoodie", "$28", "hoodie3"),
            Product("Devslopes Black Hoodie", "$32", "hoodie4")
    )

    private val shirts = listOf(
            Product("Devslopes Shirt Black", "$18", "shirt1"),
            Product("Devslopes Badge Light Gray", "$20", "shirt2"),
            Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
            Product("Devslopes Hustle", "$22", "shirt4"),
            Product("Kickflip Studios", "$18", "shirt5"),
            Product("Devslopes Shirt Black", "$18", "shirt1"),
            Product("Devslopes Badge Light Gray", "$20", "shirt2"),
            Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
            Product("Devslopes Hustle", "$22", "shirt4"),
            Product("Kickflip Studios", "$18", "shirt5")
    )

    val digitalGoods = listOf<Product>()

    fun getProducts(categoryType: String): List<Product> {
        return when (categoryType) {
            "SHIRTS" -> shirts
            "HOODIES" -> hoodies
            "HATS" -> hats
            else -> digitalGoods
        }
    }
}
