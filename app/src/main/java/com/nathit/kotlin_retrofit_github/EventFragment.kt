package com.nathit.kotlin_retrofit_github

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nathit.kotlin_retrofit_github.Adapter.SearchAdapter
import retrofit2.*

class EventFragment : Fragment() {

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var rv: RecyclerView
    lateinit var loadingDialog: ProgressDialog
    val query = "a"

    var mSwipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_event, container, false)

        rv = view.findViewById(R.id.rv_event)
        linearLayoutManager = LinearLayoutManager(context)
        rv.layoutManager = linearLayoutManager

        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout)
        mSwipeRefreshLayout!!.setOnRefreshListener {
            getData(query)
            mSwipeRefreshLayout!!.isRefreshing = false
        }

        getData(query)


        return view
    }

    private fun getData(query: String) {
        loadingDialog = ProgressDialog.show(context, "กำลังโหลดข้อมูล", "รอสักครู่...", true, false)

        val apiSearchInterface: ApiSearchInterface =
            ApiSearchInterface.retrofit.create(ApiSearchInterface::class.java)
        val call: Call<List<SearchModel>> = apiSearchInterface.loadSearch(query)

        call.enqueue(object : Callback<List<SearchModel>> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<SearchModel>>,
                response: Response<List<SearchModel>>
            ) {
                loadingDialog.dismiss()

                if (response.isSuccessful) {
                    val responseBody = response.body()!!
                    searchAdapter = SearchAdapter(activity!!.applicationContext, responseBody)
                    searchAdapter.notifyDataSetChanged()
                    rv.adapter = searchAdapter
                } else {
                }


            }

            override fun onFailure(call: Call<List<SearchModel>>, t: Throwable) {
                loadingDialog.dismiss()
                Toast.makeText(context, "Error" + t.message, Toast.LENGTH_SHORT).show()
                Log.d("Failure", "onFailure: " + t.message)
            }

        })

    }
}