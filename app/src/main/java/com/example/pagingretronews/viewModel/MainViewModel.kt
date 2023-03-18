package com.example.pagingretronews.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingretronews.network.ApiService
import com.example.pagingretronews.network.paging.ApiPagingSourse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService):ViewModel() {
    val listData = Pager(
        PagingConfig(
            pageSize = 1
        )
    ){
        ApiPagingSourse(apiService)
    }.flow.cachedIn(viewModelScope)
}