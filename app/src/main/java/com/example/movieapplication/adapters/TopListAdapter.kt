package com.example.movieapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.R
import com.example.movieapplication.models.MovieResults
import kotlinx.android.synthetic.main.top_list_item.view.*
import java.util.zip.Inflater

class TopListAdapter : RecyclerView.Adapter<TopListAdapter.TopListViewHolder>() {
    var topMoviesList  = ArrayList<MovieResults>()
    var mContext :Context?=null
    class TopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopListViewHolder {
        mContext = parent.context
        return TopListViewHolder(LayoutInflater.from(parent.context).inflate( R.layout.top_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: TopListViewHolder, position: Int) {
        holder.itemView.titletv.text = topMoviesList[position].title
        Glide.with(mContext!!).load("https://image.tmdb.org/t/p/original/"+topMoviesList[position].poster_path).into(holder.itemView.imageView)
    }

    override fun getItemCount(): Int {
        return topMoviesList.size
    }
    fun addList(mList: ArrayList<MovieResults>){
        this.topMoviesList=mList
    }
}