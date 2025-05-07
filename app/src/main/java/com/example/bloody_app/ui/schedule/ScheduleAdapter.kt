package com.example.bloody_app.ui.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemScheduleListBinding
import com.example.bloody_app.model.Schedule

class ScheduleAdapter(private val list: List<Schedule>) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(binding: ItemScheduleListBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.ivScheduleListImage
        val location: TextView = binding.tvScheduleListLocation
        val date: TextView = binding.tvScheduleListDate
        val time: TextView = binding.tvScheduleListTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ItemScheduleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = list[position]
        holder.image.setImageResource(item.image)
        holder.location.text = item.location
        holder.date.text = item.date
        holder.time.text = item.time
    }

    override fun getItemCount() = list.size
}