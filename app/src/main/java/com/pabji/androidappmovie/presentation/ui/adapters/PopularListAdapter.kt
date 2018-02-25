package com.pabji.androidappmovie.presentation.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.pabji.androidappmovie.R
import com.pabji.androidappmovie.domain.models.MoviePreview
import kotlinx.android.synthetic.main.item_main_list.view.*

class PopularListAdapter(val callback: (MoviePreview) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mList : MutableList<MoviePreview> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_list, parent, false)
        return ItemListHolder(view, callback)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewHolder = holder as ItemListHolder
        viewHolder.bindItem(mList[position])
    }
    override fun getItemCount(): Int = mList.size

    fun addData(list: List<MoviePreview>){
        mList.addAll(list)
        notifyDataSetChanged()
    }

    class ItemListHolder(itemView: View, val callback: (MoviePreview) -> Unit): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: MoviePreview){
            itemView.tv_title.text = item.title
            Glide.with(itemView.context)
                    .load("http://image.tmdb.org/t/p/w185/"+item.posterPath)
                    .centerCrop()
                    .into(itemView.iv_image)
            itemView.setOnClickListener { callback(item) }
        }
    }

    fun clearList() {
        mList.clear()
        notifyDataSetChanged()
    }
}