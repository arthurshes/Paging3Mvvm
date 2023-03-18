package com.example.pagingretronews.network

import com.example.pagingretronews.models.MainResponse
import com.example.pagingretronews.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun getPerson(
        @Query("page") page:Int
    ):MainResponse
}