package com.marcodallaba.beerbox.ui.beers_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.marcodallaba.beerbox.databinding.BeerItemBinding

class BeersListAdapter : ListAdapter<BeerItem, BeerViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BeerItemBinding.inflate(layoutInflater, parent, false)
        return BeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val uiBeerItem = getItem(position)
        holder.beerItem = uiBeerItem
        //holder.moreInfo.setOnClickListener { onMoreInfo.onNext(uiBeerItem) }
    }

    private class DiffCallback : DiffUtil.ItemCallback<BeerItem>() {
        override fun areItemsTheSame(oldItem: BeerItem, newItem: BeerItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BeerItem, newItem: BeerItem): Boolean {
            return oldItem == newItem
        }
    }
}
