package com.example.bloody_app.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemHistoryListBinding
import com.example.bloody_app.model.Schedule

class HistoryAdapter(private val list: List<Schedule>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(binding: ItemHistoryListBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.ivHistoryListImage
        val location: TextView = binding.tvHistoryListLocation
        val date: TextView = binding.tvHistoryListDate
        val time: TextView = binding.tvHistoryListTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = list[position]
        holder.image.setImageResource(item.image)
        holder.location.text = item.location
        holder.date.text = item.date
        holder.time.text = item.time
    }

    override fun getItemCount() = list.size
}