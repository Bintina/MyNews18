package com.bintina.mynews18.stories.science.api

import com.bintina.mynews18.model.NewsResult
import com.bintina.mynews18.util.Constants.SCI_END_URL
import retrofit2.http.GET

interface ApiClient {
    @GET(SCI_END_URL)
    suspend fun getScienceStories(): NewsResult?
}