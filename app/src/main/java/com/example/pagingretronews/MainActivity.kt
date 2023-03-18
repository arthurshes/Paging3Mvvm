package com.example.pagingretronews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.pagingretronews.adapter.PagingAdapter
import com.example.pagingretronews.databinding.ActivityMainBinding
import com.example.pagingretronews.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var mAdapter:PagingAdapter
    private val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapter= PagingAdapter()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.listData.collect{
                mAdapter.submitData(it)
            }
        }
        val deco = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
        binding.apply {
            recucler.apply {
                setHasFixedSize(true)
                addItemDecoration(deco)
                adapter=mAdapter
            }
        }
    }
}