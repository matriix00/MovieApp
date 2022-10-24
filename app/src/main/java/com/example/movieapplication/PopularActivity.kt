package com.example.movieapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapplication.adapters.PopularListAdapter
import com.example.movieapplication.constants.Constants
import com.example.movieapplication.models.MovieResults
import com.example.movieapplication.models.PopularMovie
import com.example.movieapplication.models.PopularResults
import com.example.movieapplication.retrofit.GetMovieClientService
import com.example.movieapplication.retrofit.GetMovieInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularActivity : BaseActivity() {
    var popListAdapter  = PopularListAdapter()
    var popList = ArrayList<PopularResults>()
    private  val TAG = "PopularActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular)
        getPopMovies()
    }
    private fun getMovie(mID:String){

    }
    private fun getPopMovies(){
        val service = GetMovieClientService.getInstance().create(GetMovieInterface::class.java)
        val call = service.getPopularMovies(Constants.API_KEY)
        call.enqueue(object : Callback<PopularMovie>{
            override fun onResponse(call: Call<PopularMovie>, response: Response<PopularMovie>) {
                popList = response.body()!!.resultsEntity as ArrayList<PopularResults>


                popListAdapter.addList(popList)
                rv.layoutManager = LinearLayoutManager(this@PopularActivity,
                    LinearLayoutManager.VERTICAL,false)
                rv.hasFixedSize()

                rv.adapter = popListAdapter
            }

            override fun onFailure(call: Call<PopularMovie>, t: Throwable) {
                Log.e(TAG, "onFailure: something went wrong" )
            }

        })
    }
}