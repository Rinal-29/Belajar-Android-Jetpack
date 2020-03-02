package com.rinal.sub1jetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.rinal.sub1jetpack.data.MoviesEntitiy
import com.rinal.sub1jetpack.data.TvEntitiy
import com.rinal.sub1jetpack.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie() : MoviesEntitiy? {
        var movies: MoviesEntitiy? = null
        for (movieEntity in DataDummy.generateDummyMovies()){
            if (movieEntity.movieId == movieId){
                movies = movieEntity
            }
        }
        return movies
    }

    fun setSelectedTvShow(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvEntitiy? {
        var tvShow: TvEntitiy? = null
        for (tvShowEntity in DataDummy.generateDummyTv()){
            if (tvShowEntity.tvId == tvShowId){
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}