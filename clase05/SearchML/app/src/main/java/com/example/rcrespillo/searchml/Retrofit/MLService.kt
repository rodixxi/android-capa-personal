package com.example.rcrespillo.searchml.Retrofit

import com.example.rcrespillo.searchml.Model.Search
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MLService {

    @GET("sites/MLA/search")
    fun searchML(@Query("q") q: String?,
                 @Header("Content-Type") contentType: String = "application/json"):
            Observable<Search>

    @GET("items/{id}")
    fun getItemImage(@Path("id") id: String?):
            Observable<BaseInfo.Result>

    @GET("items/{id}/description")
    fun getItemDescription(@Path("id") id: String?):
            Observable<FullDescription.Result>

    companion object {
        fun create(): MLService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("https://api.mercadolibre.com/")
                .build()

            return retrofit.create(MLService::class.java)
        }
    }
}


object BaseInfo {
    data class Result(val id: String,
                      val title: String,
                      val pictures: List<Pictures>)
    data class Pictures(val url: String)
}

object FullDescription {
    data class Result(val plain_text: String)
}




