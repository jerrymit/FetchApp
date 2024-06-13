package com.example.fetchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.databinding.ItemViewBinding


class ItemAdapter(private val groupedItems: Map<Int, List<Item>>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Flatten the map into a list of items
    private val itemList: List<Item> = groupedItems.flatMap { it.value }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvName.text = "List ID: ${item.listId}, Name: ${item.name}"
        }
    }
}