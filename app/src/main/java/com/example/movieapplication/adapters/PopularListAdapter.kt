package com.example.movieapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.R
import com.example.movieapplication.models.MovieDetail
import com.example.movieapplication.models.MovieResults
import com.example.movieapplication.models.PopularResults
import com.example.movieapplication.models.State
import kotlinx.android.synthetic.main.movie_sub_item.view.*
import kotlinx.android.synthetic.main.top_list_item.view.*

class PopularListAdapter() : RecyclerView.Adapter<PopularListAdapter.PopularViewHolder>() {
    var mContext:Context?=null
    var mLisst = ArrayList<State>()
    var  popList = ArrayList<PopularResults>()

    class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        mContext=parent.context
        return PopularViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_sub_item,parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.itemView.movie_title_pop.text = popList[position].title
       // holder.itemView.gen_pop.text = mLisst.get(position).gen
        holder.itemView.rating_bar_pop.rating = (popList[position].vote_average.toFloat())/2
        Glide.with(mContext!!).load("https://image.tmdb.org/t/p/original/"+popList[position].poster_path).into(holder.itemView.movie_img_pop)
    }
    //IndexOutOfBoundsException
    fun addList(mList:ArrayList<PopularResults>){
        this.popList=mList
    }
    fun addStateList(aList:ArrayList<State>){
        this.mLisst = aList
    }

    override fun getItemCount(): Int {
        return popList.size
    }
}