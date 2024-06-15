package org.d3if3096.assessment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if3096.assessment3.model.Product
import org.d3if3096.assessment3.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://4602myproductapi.000webhostapp.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProductApiService {
    @GET("/6706223096/product")
    suspend fun getProduct(
        @Header("Authorization") userId: String
    ): List<Product>

    @Multipart
    @POST("/6706223096/product")
    suspend fun postProduct(
        @Header("Authorization") userId: String,
        @Part("name") product: RequestBody,
        @Part("price") price: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus
    @GET("/6706223096/product/delete/{id}")
    suspend fun deleteProduct(
        @Header("Authorization") userId: String,
        /*@Query("id") id: String,*/
        @Path("id") id: String
    ): OpStatus
}

object ProductApi {
    val service: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }


    fun getProductUrl(imageId: String): String {
        return "${BASE_URL}/images/${imageId}"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }

