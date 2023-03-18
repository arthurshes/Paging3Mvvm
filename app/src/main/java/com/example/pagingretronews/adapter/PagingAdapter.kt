package com.example.pagingretronews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingretronews.databinding.ItemBinding
import com.example.pagingretronews.models.ResultApi

class PagingAdapter:PagingDataAdapter<ResultApi, PagingAdapter.MyViewHolder>(diffCallBaxk) {

    companion object{
        val diffCallBaxk = object : DiffUtil.ItemCallback<ResultApi>(){
            override fun areItemsTheSame(oldItem: ResultApi, newItem: ResultApi): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultApi, newItem: ResultApi): Boolean {
          return oldItem == newItem
            }

        }
    }
    inner class MyViewHolder(val binding: ItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val items = getItem(position)
        holder.binding.apply {
            Glide.with(holder.itemView).load(items?.image)
                .into(imageView)
            textView.text = items?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
   return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}