package com.example.bloody_app.ui.jadwal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemJadwalBinding
import com.example.bloody_app.model.JadwalDonor


class JadwalAdapter(private val list: List<JadwalDonor>) :
    RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>() {

    inner class JadwalViewHolder(binding: ItemJadwalBinding) : RecyclerView.ViewHolder(binding.root) {
        val eventImage: ImageView = binding.imageJadwal
        val eventLocation: TextView = binding.txtLocation
        val eventDate: TextView = binding.eventDate
        val eventTime: TextView = binding.eventTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val binding = ItemJadwalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JadwalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        val item = list[position]
        holder.eventImage.setImageResource(item.image)
        holder.eventLocation.text = item.lokasi
        holder.eventDate.text = item.tanggal
        holder.eventTime.text = item.waktu
    }

    override fun getItemCount() = list.size
}