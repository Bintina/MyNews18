package com.bintina.mynews18.data

import android.util.Log
import com.bintina.mynews18.model.News
import com.bintina.mynews18.popular.api.ApiService

object DataSource {

    suspend fun loadPopularNews(): List<News?>? {
        val apiCall = ApiService.create()

        val response = try {
            apiCall.getPopularNews()
        } catch (e: Exception){
            Log.e("PopDataSourceLog", "Error is ${e.message.toString()}")
            null
        }

        //Filter Results
        val results = response?.results
        var parameterToCheckForNull = "selection"

        val filteredForSection = results?.filterNot { News ->
            when (parameterToCheckForNull){
                "section" -> News?.section.isNullOrBlank()
                else -> false
            }
        }
        parameterToCheckForNull = "abstract"
        val filteredForBoth = filteredForSection?.filterNot { News ->
            when (parameterToCheckForNull){
                "abstract" -> News?.abstract.isNullOrBlank()
                else -> false
            }
        }

        return filteredForBoth
    }

//..................................................................................................
    suspend fun loadArtsStories(): List<News?>? {
        val apiCall = com.bintina.mynews18.stories.arts.api.ApiService.create()

        val response = try {
            apiCall.getArtStories()
        } catch (e: Exception){
            Log.e("ArtDataSourceLog", "Error is ${e.message.toString()}")
            null
        }

        //Filter Results
        val results = response?.results
        var parameterToCheckForNull = "selection"

        val filteredForSection = results?.filterNot { News ->
            when (parameterToCheckForNull){
                "section" -> News?.section.isNullOrBlank()
                else -> false
            }
        }
        parameterToCheckForNull = "abstract"
        val filteredForBoth = filteredForSection?.filterNot { News ->
            when (parameterToCheckForNull){
                "abstract" -> News?.abstract.isNullOrBlank()
                else -> false
            }
        }

        return filteredForBoth
    }

//..................................................................................................
    suspend fun loadBusinessStories(): List<News?>? {
        val apiCall = com.bintina.mynews18.stories.business.api.ApiService.create()

        val response = try {
            apiCall.getBusinessNews()
        } catch (e: Exception){
            Log.e("BusDataSourceLog", "Error is ${e.message.toString()}")
            null
        }

        //Filter Results
        val results = response?.results
        var parameterToCheckForNull = "selection"

        val filteredForSection = results?.filterNot { News ->
            when (parameterToCheckForNull){
                "section" -> News?.section.isNullOrBlank()
                else -> false
            }
        }
        parameterToCheckForNull = "abstract"
        val filteredForBoth = filteredForSection?.filterNot { News ->
            when (parameterToCheckForNull){
                "abstract" -> News?.abstract.isNullOrBlank()
                else -> false
            }
        }

        return filteredForBoth
    }

//..................................................................................................
    suspend fun loadScienceStories(): List<News?>? {
        val apiCall = com.bintina.mynews18.stories.science.api.ApiService.create()

        val response = try {
            apiCall.getScienceStories()
        } catch (e: Exception){
            Log.e("SciDataSourceLog", "Error is ${e.message.toString()}")
            null
        }

        //Filter Results
        val results = response?.results
        var parameterToCheckForNull = "selection"

        val filteredForSection = results?.filterNot { News ->
            when (parameterToCheckForNull){
                "section" -> News?.section.isNullOrBlank()
                else -> false
            }
        }
        parameterToCheckForNull = "abstract"
        val filteredForBoth = filteredForSection?.filterNot { News ->
            when (parameterToCheckForNull){
                "abstract" -> News?.abstract.isNullOrBlank()
                else -> false
            }
        }

        return filteredForBoth
    }

//..................................................................................................
    suspend fun loadTopStories(): List<News?>? {
        val apiCall = com.bintina.mynews18.stories.top.api.ApiService.create()

        val response = try {
            apiCall.getTopStories()
        } catch (e: Exception){
            Log.e("TopDataSourceLog", "Error is ${e.message.toString()}")
            null
        }

        //Filter Results
        val results = response?.results
        var parameterToCheckForNull = "selection"

        val filteredForSection = results?.filterNot { News ->
            when (parameterToCheckForNull){
                "section" -> News?.section.isNullOrBlank()
                else -> false
            }
        }
        parameterToCheckForNull = "abstract"
        val filteredForBoth = filteredForSection?.filterNot { News ->
            when (parameterToCheckForNull){
                "abstract" -> News?.abstract.isNullOrBlank()
                else -> false
            }
        }

        return filteredForBoth
    }
}