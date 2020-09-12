package com.marcodallaba.beerbox.ui.beers_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marcodallaba.beerbox.databinding.BeerItemBinding
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer

class BeerViewHolder(private val binding: BeerItemBinding
) : RecyclerView.ViewHolder(binding.root),
    LayoutContainer {

    override val containerView: View?
        get() = itemView

    var beerItem: BeerItem? = null
        set(value) {
            field = value
            Picasso.get().load(field?.imageUrl).into(binding.imageView)
            binding.titleTextView.text = field?.name
            binding.tagLine.text = field?.tagLine
            binding.description.text = field?.description
        }

}
