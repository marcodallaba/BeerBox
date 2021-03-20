package com.marcodallaba.beerbox.ui.beers

import androidx.recyclerview.widget.RecyclerView
import com.marcodallaba.beerbox.databinding.BeerItemBinding
import com.squareup.picasso.Picasso

class BeerViewHolder(
    val binding: BeerItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    var beerItem: UIBeerItem? = null
        set(value) {
            field = value
            Picasso.get().load(field?.imageUrl).into(binding.imageView)
            binding.titleTextView.text = field?.name
            binding.tagLine.text = field?.tagLine
            binding.description.text = field?.description
        }
}
