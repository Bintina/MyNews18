package com.bintina.mynews18.stories.arts.api

import com.bintina.mynews18.model.NewsResult
import com.bintina.mynews18.util.Constants.ART_END_URL
import retrofit2.http.GET

interface ApiClient {
    @GET(ART_END_URL)
    suspend fun getArtStories(): NewsResult?
}