package com.example.bloody_app.model
import com.example.bloody_app.R

data class Schedule(
    val location: String,
    val date: String,
    val time: String,
    val image: Int
)

val listScheduleLimit = listOf(
    Schedule("PMI Kota Cirebon", "8 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("PMI Kabupaten Indramayu", "10 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("PMI Majalengka", "12 Mei 2025", "08.30 - 12.30", R.drawable.image_43),
    Schedule("PMI Kuningan", "13 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
)

val listSchedule = listOf(
    Schedule("PMI Kota Cirebon", "8 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("RSUD Arjawinangun, Cirebon", "9 Mei 2025", "09.00 - 13.00", R.drawable.image_43),
    Schedule("Lapangan GOR Bima, Cirebon", "11 Mei 2025", "07.30 - 11.30", R.drawable.image_43),

    Schedule("PMI Kabupaten Indramayu", "10 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("Alun-Alun Indramayu", "13 Mei 2025", "09.00 - 12.00", R.drawable.image_43),
    Schedule("Puskesmas Sindang, Indramayu", "14 Mei 2025", "08.00 - 11.00", R.drawable.image_43),

    Schedule("PMI Majalengka", "12 Mei 2025", "08.30 - 12.30", R.drawable.image_43),
    Schedule("RSUD Majalengka", "15 Mei 2025", "09.00 - 13.00", R.drawable.image_43),
    Schedule("Taman Dirgantara, Majalengka", "16 Mei 2025", "08.00 - 11.00", R.drawable.image_43),

    Schedule("PMI Kuningan", "13 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("Taman Pandapa, Kuningan", "17 Mei 2025", "09.00 - 12.00", R.drawable.image_43),
    Schedule("RSUD 45 Kuningan", "18 Mei 2025", "08.30 - 11.30", R.drawable.image_43)
)


val listHistory = listOf(
    Schedule("PMI Cirebon", "7 Mei 2025", "08.00 - 13.00", R.drawable.image_43),
    Schedule(
        "Alun-Alun Majalengka",
        "10 Mei 2025",
        "09.00 - 12.00",
        R.drawable.image_43
    ),
    Schedule("RS Indramayu", "12 Mei 2025", "08.30 - 11.00", R.drawable.image_43)
)