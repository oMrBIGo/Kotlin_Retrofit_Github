package com.nathit.kotlin_retrofit_github

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var rv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        rv = view.findViewById(R.id.rv)
        linearLayoutManager = LinearLayoutManager(context)
        rv.layoutManager = linearLayoutManager

        getData()



        return view
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
                userAdapter = UserAdapter(activity!!.applicationContext, responseBody)
                userAdapter.notifyDataSetChanged()
                rv.adapter = userAdapter

            }

            override fun onFailure(call: Call<List<UserModelItem>?>, t: Throwable) {
                Toast.makeText(context, "Error"+t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }


}