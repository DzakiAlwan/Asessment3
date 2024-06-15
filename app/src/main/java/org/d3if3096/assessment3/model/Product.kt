package org.d3if3096.assessment3.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(

    @Json(name = "name") val product: String?,
    @Json(name = "price") val price: String?,
    @Json(name = "image") val imageId: String,
    @Json(name = "id") val id:String,
//    val mine: Int
)
@JsonClass(generateAdapter = true)
data class ProductList(val products: List<Product>)