package com.nathit.kotlin_retrofit_github.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter
import com.nathit.kotlin_retrofit_github.ApiInterface
import com.nathit.kotlin_retrofit_github.BASE_URL
import com.nathit.kotlin_retrofit_github.R
import com.nathit.kotlin_retrofit_github.UserModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AllUsersActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var rv: RecyclerView

    var TAG = "AllUsersActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_users)

        rv = findViewById(R.id.rv)
        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager

        getData()
    }

    private fun getData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUserData()

        retrofitData.enqueue(object : Callback<List<UserModelItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<UserModelItem>?>,
                response: Response<List<UserModelItem>?>
            ) {
                val responseBody = response.body()!!
                userAdapter = UserAdapter(baseContext, responseBody)
                userAdapter.notifyDataSetChanged()
                rv.adapter = userAdapter
            }

            override fun onFailure(call: Call<List<UserModelItem>?>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }

        })
    }
}