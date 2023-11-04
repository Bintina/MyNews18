package com.bintina.mynews18.stories.top.api

import com.bintina.mynews18.model.News
import com.bintina.mynews18.model.NewsResult
import com.bintina.mynews18.util.Constants.TOP_END_URL
import retrofit2.http.GET

interface ApiClient {
    @GET(TOP_END_URL)
    suspend fun getTopStories(): NewsResult?
}