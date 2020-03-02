package com.rinal.sub1jetpack.ui.tv

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @Before
    fun setUp(){
        viewModel = TvViewModel()
    }

    @Test
    fun getTvShow() {
        val tvEntity = viewModel.getTvShow()
        assertNotNull(tvEntity)
        assertEquals(10, tvEntity.size)
    }
}