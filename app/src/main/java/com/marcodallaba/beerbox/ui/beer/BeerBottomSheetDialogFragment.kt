package com.marcodallaba.beerbox.ui.beer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.marcodallaba.beerbox.R
import com.marcodallaba.beerbox.ui.beers.UIBeerItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.beer_bottom_sheet_dialog.*

class BeerBottomSheetDialogFragment : BottomSheetDialogFragment() {

    companion object {
        private const val BEER_KEY = "BEER"

        @JvmStatic
        fun newInstance(beerItem: UIBeerItem) = BeerBottomSheetDialogFragment().apply {
            arguments = bundleOf(BEER_KEY to beerItem)
        }
    }

    override fun getTheme(): Int = R.style.BeerBottomSheetDialogFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.beer_bottom_sheet_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val beerItem: UIBeerItem? = arguments?.getParcelable(BEER_KEY)
        Picasso.get().load(beerItem?.imageUrl).into(imageView)
        titleTextView.text = beerItem?.name
        tagLine.text = beerItem?.tagLine
        description.text = beerItem?.description
    }
}