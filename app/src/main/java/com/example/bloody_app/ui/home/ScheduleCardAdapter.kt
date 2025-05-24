package com.example.bloody_app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemScheduleCardBinding
import com.example.bloody_app.model.Schedule

class ScheduleCardAdapter(private val items: List<Schedule>) :
    RecyclerView.Adapter<ScheduleCardAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(binding: ItemScheduleCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.ivScheduleCardImage
        val location: TextView = binding.tvScheduleCardLocation
        val date: TextView = binding.tvScheduleCardDate
        val time: TextView = binding.tvScheduleCardTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding =
            ItemScheduleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.location.text = item.location
        holder.date.text = item.date
        holder.time.text = item.time
    }

    override fun getItemCount() = items.size
}