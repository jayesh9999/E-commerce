package com.example.e_commerce.api

import com.example.e_commerce.dataclass.data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiInterface {

    @GET("rest/V1/productdetails/6701/253620")
    suspend fun getData(@Query("lang") lang : String,@Query("store") store : String) : Response<data>
}