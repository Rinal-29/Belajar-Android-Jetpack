package com.rinal.sub1jetpack.ui.tv

import androidx.lifecycle.ViewModel
import com.rinal.sub1jetpack.data.TvEntitiy
import com.rinal.sub1jetpack.utils.DataDummy

class TvViewModel: ViewModel() {
    fun getTvShow(): List<TvEntitiy> = DataDummy.generateDummyTv()
}