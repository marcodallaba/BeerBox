package com.marcodallaba.beerbox.ui.beers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.marcodallaba.beerbox.databinding.BeerItemBinding
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject


class BeersAdapter : ListAdapter<UIBeerItem, BeerViewHolder>(DiffCallback()) {


    val onMoreInfo: Subject<UIBeerItem> = PublishSubject.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BeerItemBinding.inflate(layoutInflater, parent, false)
        return BeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val uiBeerItem = getItem(position)
        holder.beerItem = uiBeerItem
        holder.binding.moreInfo.setOnClickListener { onMoreInfo.onNext(uiBeerItem) }
    }

    private class DiffCallback : DiffUtil.ItemCallback<UIBeerItem>() {
        override fun areItemsTheSame(oldItem: UIBeerItem, newItem: UIBeerItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UIBeerItem, newItem: UIBeerItem): Boolean {
            return oldItem == newItem
        }

    }

}
