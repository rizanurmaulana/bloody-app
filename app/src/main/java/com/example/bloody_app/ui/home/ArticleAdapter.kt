package com.example.bloody_app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bloody_app.databinding.ItemArticleBinding
import com.example.bloody_app.model.Articles

class ArticleAdapter(private val items: List<Articles>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageUrl: ImageView = binding.ivArticleImage
        val title: TextView = binding.tvArticleTitle
        val description: TextView = binding.tvArticleDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = items[position]
        holder.imageUrl.setImageResource(item.imageUrl)
        holder.title.text = item.title
        holder.description.text = item.description
    }

    override fun getItemCount() = items.size
}