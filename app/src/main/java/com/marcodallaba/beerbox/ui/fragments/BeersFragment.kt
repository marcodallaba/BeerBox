package com.marcodallaba.beerbox.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.marcodallaba.beerbox.R
import com.marcodallaba.beerbox.databinding.FragmentBeersBinding

class BeersFragment : Fragment() {

    private lateinit var binding: FragmentBeersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beers, container, false)

        return binding.root
    }


}