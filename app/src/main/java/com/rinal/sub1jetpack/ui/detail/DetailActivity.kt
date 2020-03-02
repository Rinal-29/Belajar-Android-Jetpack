package com.rinal.sub1jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.rinal.sub1jetpack.R
import com.rinal.sub1jetpack.data.MoviesEntitiy
import com.rinal.sub1jetpack.data.TvEntitiy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_content.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras

        if (extras != null){
            val movieId = extras.getString(MOVIE)
            val tvShowId = extras.getString(TV_SHOW)

            if (movieId != null){
                viewModel.setSelectedMovie(movieId)
                selectedMovie(
                    viewModel.getMovie()
                )
                supportActionBar?.title = getString(R.string.detail_movie)
            }

            if (tvShowId != null){
                viewModel.setSelectedTvShow(tvShowId)
                selectedTvShow(
                    viewModel.getTvShow()
                )
                supportActionBar?.title = getString(R.string.detail_tv_show)
            }
        }
    }

    private fun selectedMovie(moviesEntity: MoviesEntitiy?){
        title_content.text = moviesEntity?.movieTitle
        rate_content.text = moviesEntity?.movieRate
        desc_content.text = moviesEntity?.movieDesc

        Picasso.get()
            .load(moviesEntity?.moviePoster)
            .error(R.drawable.ic_error)
            .into(img_content)
    }

    private fun selectedTvShow(tvShowEntity: TvEntitiy?){
        title_content.text = tvShowEntity?.tvTitle
        rate_content.text = tvShowEntity?.tvRate
        desc_content.text = tvShowEntity?.tvDesc

        Picasso.get()
            .load(tvShowEntity?.tvPoster)
            .error(R.drawable.ic_error)
            .into(img_content)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
