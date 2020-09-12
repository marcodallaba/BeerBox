package com.marcodallaba.beerbox.ui.main

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.databinding.DataBindingUtil
import com.marcodallaba.beerbox.R
import com.marcodallaba.beerbox.databinding.ActivityMainBinding
import com.marcodallaba.beerbox.ui.fragments.BeersFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //This is presentation logic, should be in a view model
        binding.toolbarTitle.text = SpannableStringBuilder().append(getString(R.string.beer_name))
            .append(" ")
            .append(getString(R.string.box_name), StyleSpan(Typeface.BOLD), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BeersFragment())
                .commit()
    }
}