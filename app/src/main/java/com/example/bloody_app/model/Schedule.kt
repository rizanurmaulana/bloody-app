package com.example.bloody_app.model

import com.example.bloody_app.R
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Schedule(
    val id: String,
    val location: String,
    val date: String,
    val time: String,
    val image: Int
) : Parcelable

val listScheduleLimit = listOf(
    Schedule("1", "PMI Kota Cirebon", "8 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("2", "PMI Kabupaten Indramayu", "10 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("3", "PMI Majalengka", "12 Mei 2025", "08.30 - 12.30", R.drawable.image_43),
    Schedule("4", "PMI Kuningan", "13 Mei 2025", "08.00 - 12.00", R.drawable.image_43)
)


val listSchedule = listOf(
    Schedule("5", "PMI Kota Cirebon", "8 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("6", "RSUD Arjawinangun, Cirebon", "9 Mei 2025", "09.00 - 13.00", R.drawable.image_43),
    Schedule(
        "7",
        "Lapangan GOR Bima, Cirebon",
        "11 Mei 2025",
        "07.30 - 11.30",
        R.drawable.image_43
    ),

    Schedule("8", "PMI Kabupaten Indramayu", "10 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("9", "Alun-Alun Indramayu", "13 Mei 2025", "09.00 - 12.00", R.drawable.image_43),
    Schedule(
        "10",
        "Puskesmas Sindang, Indramayu",
        "14 Mei 2025",
        "08.00 - 11.00",
        R.drawable.image_43
    ),

    Schedule("11", "PMI Majalengka", "12 Mei 2025", "08.30 - 12.30", R.drawable.image_43),
    Schedule("12", "RSUD Majalengka", "15 Mei 2025", "09.00 - 13.00", R.drawable.image_43),
    Schedule(
        "13",
        "Taman Dirgantara, Majalengka",
        "16 Mei 2025",
        "08.00 - 11.00",
        R.drawable.image_43
    ),

    Schedule("14", "PMI Kuningan", "13 Mei 2025", "08.00 - 12.00", R.drawable.image_43),
    Schedule("15", "Taman Pandapa, Kuningan", "17 Mei 2025", "09.00 - 12.00", R.drawable.image_43),
    Schedule("16", "RSUD 45 Kuningan", "18 Mei 2025", "08.30 - 11.30", R.drawable.image_43)
)


val listHistory = listOf(
    Schedule("17", "PMI Cirebon", "7 Mei 2025", "11.35", R.drawable.image_43),
    Schedule("18", "Alun-Alun Majalengka", "10 Mei 2025", "09.45", R.drawable.image_43),
    Schedule("19", "RS Indramayu", "12 Mei 2025", "10.30", R.drawable.image_43)
)
