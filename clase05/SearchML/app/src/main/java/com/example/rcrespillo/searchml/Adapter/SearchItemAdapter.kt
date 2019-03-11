package com.example.rcrespillo.searchml.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rcrespillo.searchml.Model.Search
import com.example.rcrespillo.searchml.R

class SearchItemAdapter(internal var context: Context, internal var itemList:List<Search.Result>)
    :RecyclerView.Adapter<SearchItemViewHolder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SearchItemViewHolder {
        val itemView = LayoutInflater.from(p0.context)
            .inflate(R.layout.search_item_ml, p0, false)
        return SearchItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(p0: SearchItemViewHolder, p1: Int) {
        //p0.itemImage.setImageURI()
        p0.itemTitle.text = itemList[p1].title
        p0.itemPrice.text = itemList[p1].price.toString()
    }

}