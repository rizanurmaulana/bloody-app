package com.example.bloody_app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.R
import com.example.bloody_app.model.JadwalDonor

class JadwalCardAdapter(private val list: List<JadwalDonor>) :
    RecyclerView.Adapter<JadwalCardAdapter.JadwalViewHolder>() {

    inner class JadwalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val eventImage: ImageView = view.findViewById(R.id.eventImage)
        val eventLocation: TextView = view.findViewById(R.id.eventLocation)
        val eventDate: TextView = view.findViewById(R.id.eventDate)
        val eventTime: TextView = view.findViewById(R.id.eventTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jadwal_card, parent, false)
        return JadwalViewHolder(view)
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