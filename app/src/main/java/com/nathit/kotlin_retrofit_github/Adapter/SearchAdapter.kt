package com.nathit.kotlin_retrofit_github.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nathit.kotlin_retrofit_github.Item
import com.nathit.kotlin_retrofit_github.SearchModel
import com.nathit.kotlin_retrofit_github.databinding.SearchItemBinding


class SearchAdapter(private val context: Context, private val search_List: List<SearchModel>) :
        RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

            class ViewHolder(val binding: SearchItemBinding) : RecyclerView.ViewHolder(binding.root) {
                fun bind(data: SearchModel) {
                    binding.searchData = data
                    binding.executePendingBindings()
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SearchItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = search_List[position].items
        holder.binding.titleTv.text = items[position].login
    }

    override fun getItemCount(): Int {
        return search_List.size
    }


}