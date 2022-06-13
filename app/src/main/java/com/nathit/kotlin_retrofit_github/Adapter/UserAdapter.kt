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
import com.nathit.kotlin_retrofit_github.Adapter.UserAdapter.*
import com.nathit.kotlin_retrofit_github.R
import com.nathit.kotlin_retrofit_github.UserModelItem
import org.w3c.dom.Text

class UserAdapter(private val context: Context, private val users_List: List<UserModelItem>) :

    RecyclerView.Adapter<ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var uidTv: TextView = itemView.findViewById(R.id.uIdTv)
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)
        var photoTv: ImageView = itemView.findViewById(R.id.photoIv)
        var nodeIdTv: TextView = itemView.findViewById(R.id.nodeIdTv)
        var btnHtml: Button = itemView.findViewById(R.id.btnHtml)
        var typeTv: TextView = itemView.findViewById(R.id.TypeTv)
        var linear_2: LinearLayout = itemView.findViewById(R.id.linear_2)
        var linear_3: LinearLayout = itemView.findViewById(R.id.linear_3)
        var linear_4: LinearLayout = itemView.findViewById(R.id.linear_4)
        var linear_5: LinearLayout = itemView.findViewById(R.id.linear_5)
        var btnShow: Button = itemView.findViewById(R.id.btnShow)
        var btnHide: Button = itemView.findViewById(R.id.btnHide)

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


            holder.btnShow.setOnClickListener {
                holder.linear_2.visibility = View.VISIBLE
                holder.linear_3.visibility = View.VISIBLE
                holder.linear_4.visibility = View.VISIBLE
                holder.linear_5.visibility = View.VISIBLE
                holder.btnShow.visibility = View.GONE
                holder.btnHide.visibility = View.VISIBLE

            }
            holder.btnHide.setOnClickListener {
                holder.btnShow.text = "แสดงข้อมูล"
                holder.linear_2.visibility = View.GONE
                holder.linear_3.visibility = View.GONE
                holder.linear_4.visibility = View.GONE
                holder.linear_5.visibility = View.GONE
                holder.btnShow.visibility = View.VISIBLE
                holder.btnHide.visibility = View.GONE
            }

        holder.nodeIdTv.text = "nodeID: " + "\n" + users_List[position].node_id
        if (users_List[position].type == "User") {
            holder.typeTv.text = "ผู้ใช้งาน"
        } else if (users_List[position].type == "Organization") {
            holder.typeTv.text = "องค์กร"
        } else {
            holder.typeTv.text = "ไม่พบข้อมูล"
        }
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