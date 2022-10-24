package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.adapters.PopularListAdapter
import com.example.movieapplication.adapters.TopListAdapter
import com.example.movieapplication.constants.Constants
import com.example.movieapplication.models.*
import com.example.movieapplication.retrofit.GetIMDBClient
import com.example.movieapplication.retrofit.GetMovieClientService
import com.example.movieapplication.retrofit.GetMovieInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_sub_item.view.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {

    var toplistAdapter: TopListAdapter = TopListAdapter()
    var popMovieDetails = ArrayList<MovieDetail>()
    var popListAdapter :PopularListAdapter =PopularListAdapter()
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTopMovies()
        getPopularMovies()
        seeall.setOnClickListener{
            val i = Intent(this@MainActivity,PopularActivity::class.java)
            startActivity(i)
        }

    }


    private fun getPopularMovies(){
        val service =GetMovieClientService.getInstance().create(GetMovieInterface::class.java)
        val call = service.getPopularMovies(Constants.API_KEY)

        call.enqueue(object : Callback<PopularMovie> {
            override fun onResponse(call: Call<PopularMovie>, response: Response<PopularMovie>) {
                var popMovieResults :ArrayList<PopularResults> = response.body()!!.resultsEntity as ArrayList<PopularResults>

                getAMovie(popMovieResults[0].id)



            }

            override fun onFailure(call: Call<PopularMovie>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Something went wrong",Toast.LENGTH_LONG).show()
                Log.e(TAG, "onFailure: Something went wrong in pop"+t.localizedMessage )
            }

        })

    }
    private fun getTopMovies() {
        val service = GetMovieClientService.getInstance().create(GetMovieInterface::class.java)
        val call = service.getTopRated(Constants.API_KEY)
        call.enqueue(object : Callback<TopMovie>{
            override fun onResponse(call: Call<TopMovie>, response: Response<TopMovie>) {
                Log.e(TAG, "onResponse: "+response.body().toString() )
                toplistAdapter.addList(response.body()!!.results as ArrayList<MovieResults>)
                rv.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)

                rv.adapter = toplistAdapter
            }

            override fun onFailure(call: Call<TopMovie>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Something went wrong",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getAMovie(dId: Int){
        val service = GetMovieClientService.getInstance().create(GetMovieInterface::class.java)
        val call = service.getMovieDetails(dId,Constants.API_KEY)

        call.enqueue(object: Callback<MovieDetail>{
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                val imdbID = response.body()!!.imdb_id
                var genString = ""

                val b =( response.body()!!.vote_average)/2
                val gen =response.body()!!.genresEntity
                for (arr in gen){
                    genString =genString+ arr.name+","

                }
                movie_title_pop.text = response.body()!!.title
                rating_bar_pop.rating= b.toFloat()

                gen_pop.text = genString
                Glide.with(this@MainActivity).load("https://image.tmdb.org/t/p/original/"+response.body()!!.poster_path).into(movie_img_pop)

            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {

            }

        })
    }

    /*  private fun getMovieDetail(dId:Int){
          val service = GetMovieClientService.getInstance().create(GetMovieInterface::class.java)
          val call = service.getMovieDetails(dId,Constants.API_KEY)
          call.enqueue(object : Callback<MovieDetail>{
              override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                  val imdbID = response.body()!!.imdb_id
                  var genString = ""
                  var rate=""
                  var rateIn=0
                  Log.e(TAG, "onResponse:movie detail "+ imdbID)

                  //Log.e(TAG, "onResponse:getRating "+getRating(imdbID) )


                  popMovieDetails.add(response.body()!!)
                  Log.e(TAG, "onResponse: imdbID"+ response.body()!!)
                  rate = getRating(imdbID)
                  rateIn = if (rate==""){
                      0
                  }else {
                      rate.toInt()
                  }
                  var gen =response.body()!!.genresEntity
                  for (arr in gen){
                      genString =genString+ arr.name+","

                  }
                  Log.e(TAG, "onResponse: movie detail list"+popMovieDetails )
                  Log.e(TAG, "onResponse: rattt"+rateIn )
                  mList.add(State( rateIn,genString))
                  popListAdapter.addStateList(mList)
                  Log.e(TAG, "onResponse: list of gen and rata"+mList )
                  Log.e(TAG, "getMovieDetail: asd"+mList.size )

              }


              override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                  Log.e(TAG, "onFailure: Something went wrong in detail"+t.localizedMessage )
              }

          })

      }*/

}

