package com.bintina.mynews18.stories.business.api

import com.bintina.mynews18.model.NewsResult
import com.bintina.mynews18.util.Constants.BUS_END_URL
import retrofit2.http.GET

interface ApiClient {
    @GET(BUS_END_URL)
    suspend fun getBusinessNews(): NewsResult?
}