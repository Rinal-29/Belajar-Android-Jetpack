package com.rinal.sub1jetpack.ui.detail

import com.rinal.sub1jetpack.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTv()[0]
    private val movieId = dummyMovie.movieId
    private val tvId = dummyTvShow.tvId

    @Before
    fun setUp(){
        detailViewModel = DetailViewModel()
        detailViewModel.setSelectedMovie(movieId)
        detailViewModel.setSelectedTvShow(tvId)
    }

    @Test
    fun getMovie() {
        detailViewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = detailViewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity?.movieId)
        assertEquals(dummyMovie.movieTitle, movieEntity?.movieTitle)
        assertEquals(dummyMovie.moviePoster, movieEntity?.moviePoster)
        assertEquals(dummyMovie.movieRate, movieEntity?.movieRate)
        assertEquals(dummyMovie.movieDesc, movieEntity?.movieDesc)
    }

    @Test
    fun getTvShow() {
        detailViewModel.setSelectedTvShow(dummyTvShow.tvId)
        val tvEntity = detailViewModel.getTvShow()
        assertNotNull(tvEntity)
        assertEquals(dummyTvShow.tvId, tvEntity?.tvId)
        assertEquals(dummyTvShow.tvTitle, tvEntity?.tvTitle)
        assertEquals(dummyTvShow.tvPoster, tvEntity?.tvPoster)
        assertEquals(dummyTvShow.tvDesc, tvEntity?.tvDesc)
        assertEquals(dummyTvShow.tvRate, tvEntity?.tvRate)
    }
}