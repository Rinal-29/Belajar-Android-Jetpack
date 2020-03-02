package com.rinal.sub1jetpack.ui.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rinal.sub1jetpack.R
import com.rinal.sub1jetpack.data.TvEntitiy
import com.rinal.sub1jetpack.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_movie.view.*

class TvAdapter: RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private var listTvShow = ArrayList<TvEntitiy>()

    fun setTvShow(tvShow: List<TvEntitiy>?){
        if (tvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = TvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_movie, parent, false))

    override fun getItemCount() = listTvShow.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShows = listTvShow[position]
        holder.bind(tvShows)
    }

    class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShows: TvEntitiy) {
            itemView.apply {
                title.text = tvShows.tvTitle
                rate.text = tvShows.tvRate
                desc.text = tvShows.tvDesc

                Picasso.get()
                    .load(tvShows.tvPoster)
                    .error(R.drawable.ic_error)
                    .into(poster)
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.TV_SHOW, tvShows.tvId)
                itemView.context.startActivity(intent)
            }
        }
    }
}