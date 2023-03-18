package com.example.pagingretronews.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingretronews.models.ResultApi
import com.example.pagingretronews.network.ApiService

class ApiPagingSourse(private val apiService: ApiService):PagingSource<Int,ResultApi>() {
    override fun getRefreshKey(state: PagingState<Int, ResultApi>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultApi> {
       return  try {
           val currentPage = params.key?: 1
           val response = apiService.getPerson(currentPage)
           val data = response.results?: emptyList()
           val responseData = mutableListOf<ResultApi>()
           responseData.addAll(data)
           LoadResult.Page(
               data=responseData,
               prevKey = if (currentPage==1) null else -1,
               nextKey = currentPage.plus(1)
           )
       }catch (e:Exception){
           LoadResult.Error(e)
       }
    }

}