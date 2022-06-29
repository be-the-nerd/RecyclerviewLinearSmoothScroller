package com.divyansh.recyclerviewlinearsmoothscroller

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.divyansh.recyclerviewlinearsmoothscroller.databinding.ListItemBinding

class ListAdapter(val itemList: List<Item>): RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            image.setImageResource(item.image)
            text.text = item.text
            root.setOnClickListener{
                Toast.makeText(it.context, item.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = itemList.size
}