package com.rinal.sub1jetpack.ui.tv


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.rinal.sub1jetpack.R
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvViewModel::class.java]
            val tvShow = viewModel.getTvShow()

            val tvShowAdapter = TvAdapter()
            tvShowAdapter.setTvShow(tvShow)

            rv_tv.layoutManager = LinearLayoutManager(context)
            rv_tv.setHasFixedSize(true)
            rv_tv.adapter = tvShowAdapter
        }
    }

}
