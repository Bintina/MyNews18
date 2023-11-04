package com.bintina.mynews18.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bintina.mynews18.R
import com.bintina.mynews18.databinding.ItemRowBinding
import com.bintina.mynews18.model.News
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat

class Adapter(): RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    var popularNewsList: List<News?> = mutableListOf<News?>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Adapter.ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = popularNewsList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(popularNewsList[position])
    }

    class ItemViewHolder(private val view: ItemRowBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(news: News?){
            //Image View
            Glide.with(view.newsImage.context)
                .load(news?.media?.first()?.mediaMetadata?.first()?.url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .centerCrop()
                .into(view.newsImage)

            //Date View
            view.date.text = SimpleDateFormat("d/M/Y").format(news?.publishedDate)

            //Section View
            view.section.text = "${news?.section} > ${news?.subsection}"

            //Caption View
            view.caption.text = news?.abstract
            }
        }
}


