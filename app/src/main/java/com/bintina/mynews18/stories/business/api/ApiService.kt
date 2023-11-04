package com.bintina.mynews18.stories.business.api

import com.bintina.mynews18.util.Constants.TOP_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {
    fun create(): ApiClient{
        val retrofit = Retrofit.Builder()
            .baseUrl(TOP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiClient::class.java)
    }
}