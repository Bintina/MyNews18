package com.bintina.mynews18.popular.api

import com.bintina.mynews18.model.NewsResult
import com.bintina.mynews18.util.Constants.POP_END_URL
import retrofit2.http.GET

interface ApiClient {
    @GET(POP_END_URL)
    suspend fun getPopularNews(): NewsResult?
}