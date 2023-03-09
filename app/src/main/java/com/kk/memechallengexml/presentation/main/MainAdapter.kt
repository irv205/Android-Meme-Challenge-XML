package com.kk.memechallengexml.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kk.memechallengexml.databinding.ItemMemeBinding
import com.kk.memechallengexml.domain.model.Meme

class MainAdapter() : ListAdapter<Meme, MainAdapter.ViewHolder>(LaunchesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMemeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ItemMemeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Meme){
            binding.apply {
                tvNameMeme.text = item.name
                Glide.with(ivMeme).load(item.img).into(ivMeme)
            }
        }
    }
}

object LaunchesDiffCallback : DiffUtil.ItemCallback<Meme>(){

    override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
        return oldItem == newItem
    }
}