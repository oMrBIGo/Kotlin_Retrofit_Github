package com.nathit.kotlin_retrofit_github.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter.*
import com.nathit.kotlin_retrofit_github.R
import com.nathit.kotlin_retrofit_github.UserModelItem

class UserAdapter(private val context: Context, private val users_List: List<UserModelItem>):
    RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var uidTv: TextView = itemView.findViewById(R.id.uIdTv)
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)
        var photoTv: ImageView = itemView.findViewById(R.id.photoIv)
        var nodeIdTv: TextView = itemView.findViewById(R.id.nodeIdTv)
        var btnHtml: Button = itemView.findViewById(R.id.btnHtml)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uidTv.text = "ไอดี: " + users_List[position].id.toString()
        holder.titleTv.text = "ชื่อผู้ใช้งาน: " + users_List[position].login
        Glide.with(context)
            .load(users_List[position].avatar_url)
            .centerCrop()
            .placeholder(R.drawable.progress_anim)
            .error(R.drawable.progress_anim)
            .into(holder.photoTv)
        holder.nodeIdTv.text = "nodeID: " + users_List[position].node_id

        holder.btnHtml.setOnClickListener {
            val url = users_List[position].html_url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return users_List.size
    }
}