package com.nathit.kotlin_retrofit_github

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nathit.kotlin_retrofit_github.Adapter.SearchAdapter
import retrofit2.Retrofit

class EventFragment : Fragment() {

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var rv: RecyclerView
    lateinit var loadingDialog: ProgressDialog

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
            getData()
            mSwipeRefreshLayout!!.isRefreshing = false
        }

        getData()


        return view
    }

    private fun getData() {
        loadingDialog = ProgressDialog.show(context, "กำลังโหลดข้อมูล","รอสักครู่...",true, false)
        val retrofitBuilder = Retrofit.Builder()

    }

}