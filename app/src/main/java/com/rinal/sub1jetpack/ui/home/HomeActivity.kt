package com.rinal.sub1jetpack.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinal.sub1jetpack.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pagersAdapter = PagersAdapter (this, supportFragmentManager)
        view_pager.adapter = pagersAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }
}
