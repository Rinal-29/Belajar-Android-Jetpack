package com.rinal.sub1jetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.rinal.sub1jetpack.data.MoviesEntitiy
import com.rinal.sub1jetpack.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie(): List<MoviesEntitiy> = DataDummy.generateDummyMovies()
}