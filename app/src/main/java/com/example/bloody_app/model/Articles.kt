package com.example.bloody_app.model

import com.example.bloody_app.R

data class Articles(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: Int
)

val listArticles = listOf(
    Articles(1, "3 manfaat Donor Darah Bagi Kesehatan Tubuh", "Lorem ipsum dolor sit amet, consectetur adipiscing elit...", R.drawable.image_169, ),
    Articles(2, "Kenali Donor Darah dan Beragam Manfaatnya", "Lorem ipsum dolor sit amet, consectetur adipiscing elit...", R.drawable.image_169, )
)