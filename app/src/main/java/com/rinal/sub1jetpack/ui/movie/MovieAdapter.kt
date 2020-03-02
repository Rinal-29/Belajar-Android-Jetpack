package com.rinal.sub1jetpack.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rinal.sub1jetpack.R
import com.rinal.sub1jetpack.data.MoviesEntitiy
import com.rinal.sub1jetpack.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_movie.view.*
import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<MoviesEntitiy>()

    fun setMovies(movies : List<MoviesEntitiy>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_movie, parent, false))

    override fun getItemCount() = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    class MovieViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: MoviesEntitiy) {
            itemView.apply {
                title.text = movies.movieTitle
                rate.text = movies.movieRate
                desc.text = movies.movieDesc
                Picasso.get()
                    .load(movies.moviePoster)
                    .error(R.drawable.ic_error)
                    .into(poster)
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.MOVIE, movies.movieId)
                itemView.context.startActivity(intent)
            }
        }
    }
}