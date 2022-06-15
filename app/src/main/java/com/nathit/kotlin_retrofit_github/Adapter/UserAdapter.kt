package com.nathit.kotlin_retrofit_github.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nathit.kotlin_retrofit_github.Activity.ProfileActivity
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter.*
import com.nathit.kotlin_retrofit_github.R
import com.nathit.kotlin_retrofit_github.UserModelItem
import com.nathit.kotlin_retrofit_github.databinding.UserItemBinding
import org.w3c.dom.Text
import java.util.logging.Handler as Handler1

class UserAdapter(private val context: Context, private val users_List: List<UserModelItem>) :
    RecyclerView.Adapter<ViewHolder>() {


    class ViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: UserModelItem) {
            binding.userData = data
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.titleTv.text = "username: " + users_List[position].login

        Glide.with(context)
            .load(users_List[position].avatar_url)
            .centerCrop()
            .placeholder(R.drawable.progress_anim)
            .error(R.drawable.progress_anim)
            .into(holder.binding.photoIv)

        holder.binding.btnShow.setOnClickListener {
            holder.binding.linear2.visibility = View.VISIBLE
            holder.binding.linear3.visibility = View.VISIBLE
            holder.binding.linear5.visibility = View.VISIBLE
            holder.binding.btnShow.visibility = View.GONE
            holder.binding.btnHide.visibility = View.VISIBLE


        }
        holder.binding.btnHide.setOnClickListener {
            holder.binding.linear2.visibility = View.GONE
            holder.binding.linear3.visibility = View.GONE
            holder.binding.linear5.visibility = View.GONE
            holder.binding.btnShow.visibility = View.VISIBLE
            holder.binding.btnHide.visibility = View.GONE
        }

        holder.binding.nodeIdTv.text = "nodeID: " + "\n" + users_List[position].node_id
        if (users_List[position].type == "User") {
            holder.binding.uIdTv.text = "ID:"+users_List[position].id.toString() +" | " + "Member"
        } else if (users_List[position].type == "Organization") {
            holder.binding.uIdTv.text = "ID:"+users_List[position].id.toString() +" | " + "Admin"
        } else {
            holder.binding.uIdTv.text = "Found Data!"
        }
        holder.binding.btnHtml.setOnClickListener {
            val url = users_List[position].html_url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse(url)
            context.startActivity(intent)
        }

        holder.binding.btnProFile.setOnClickListener {
            val intent = Intent(context,ProfileActivity::class.java)
            intent.putExtra("profile_url", users_List[position].url)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return users_List.size
    }


}