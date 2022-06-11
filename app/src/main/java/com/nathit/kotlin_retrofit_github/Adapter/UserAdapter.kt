package com.nathit.kotlin_retrofit_github.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter.*
import com.nathit.kotlin_retrofit_github.R
import com.nathit.kotlin_retrofit_github.UserModelItem

class UserAdapter(private val context: Context, private val users_List: List<UserModelItem>):
    RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var uidTv: TextView = itemView.findViewById(R.id.uIdTv)
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)
        var photoTv: ImageView = itemView.findViewById(R.id.photoIv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uidTv.text = users_List[position].id.toString()
        holder.titleTv.text = users_List[position].login
    }

    override fun getItemCount(): Int {
        return users_List.size
    }
}