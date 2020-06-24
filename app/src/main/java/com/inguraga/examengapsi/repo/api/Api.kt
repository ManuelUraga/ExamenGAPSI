package com.inguraga.examengapsi.repo.api

import com.inguraga.examengapsi.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("plp") // force-plp=[true] search-string=[criterio] page-number=[1] number-of-items-per-page=[1]
    fun searchProduct(@Query("force-plp") forcePlp:Boolean,
                      @Query("search-string")text:String,
                      @Query("page-number")pageNumber: Int,
                      @Query("number-of-items-per-page")itemPerPage: Int): Call<Product>?

    companion object{
        operator fun invoke() : Api{
            return Retrofit.Builder()
                .baseUrl("https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }

}