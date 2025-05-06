package com.example.bloody_app.model
import com.example.bloody_app.R

data class JadwalDonor(
    val lokasi: String,
    val tanggal: String,
    val waktu: String,
    val image: Int
)

val listJadwal = listOf(
    JadwalDonor("PMI Cirebon", "7 Mei 2025", "08.00 - 13.00", R.drawable.image_43),
    JadwalDonor(
        "Alun-Alun Majalengka",
        "10 Mei 2025",
        "09.00 - 12.00",
        R.drawable.image_43
    ),
    JadwalDonor("RS Indramayu", "12 Mei 2025", "08.30 - 11.00", R.drawable.image_43)
)
