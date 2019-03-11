package com.example.rcrespillo.searchml.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.search_item_ml.view.*

class SearchItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val itemImage = itemView.itemImageView
    val itemTitle = itemView.itemTitleText
    val itemPrice = itemView.itemPriceText

}