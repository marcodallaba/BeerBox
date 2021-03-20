package com.marcodallaba.beerbox.ui.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.marcodallaba.beerbox.R
import com.marcodallaba.beerbox.ui.beers.UIBeerItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.marcodallaba.beerbox.databinding.BeerBottomSheetDialogBinding
import com.squareup.picasso.Picasso

class BeerBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        private const val BEER_KEY = "BEER"

        @JvmStatic
        fun newInstance(beerItem: UIBeerItem) = BeerBottomSheetDialogFragment().apply {
            arguments = bundleOf(BEER_KEY to beerItem)
        }
    }

    private lateinit var binding: BeerBottomSheetDialogBinding

    override fun getTheme(): Int = R.style.BeerBottomSheetDialogFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BeerBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val beerItem: UIBeerItem? = arguments?.getSerializable(BEER_KEY) as UIBeerItem?
        Picasso.get().load(beerItem?.imageUrl).into(binding.imageView)
        binding.titleTextView.text = beerItem?.name
        binding.tagLine.text = beerItem?.tagLine
        binding.description.text = beerItem?.description
    }
}