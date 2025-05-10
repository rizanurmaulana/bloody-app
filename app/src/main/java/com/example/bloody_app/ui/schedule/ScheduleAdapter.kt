package com.example.bloody_app.ui.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemScheduleListBinding
import com.example.bloody_app.model.Schedule

class ScheduleAdapter(
    private val list: List<Schedule>,
    private val onItemClick: (Schedule) -> Unit
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(private val binding: ItemScheduleListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(schedule: Schedule) {
            binding.ivScheduleListImage.setImageResource(schedule.image)
            binding.tvScheduleListLocation.text = schedule.location
            binding.tvScheduleListDate.text = schedule.date
            binding.tvScheduleListTime.text = schedule.time

            binding.root.setOnClickListener {
                onItemClick(schedule)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ItemScheduleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
