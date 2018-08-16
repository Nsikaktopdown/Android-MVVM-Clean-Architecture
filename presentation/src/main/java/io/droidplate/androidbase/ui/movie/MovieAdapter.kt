package io.droidplate.androidbase.ui.movie

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.droidplate.androidbase.R
import io.droidplate.androidbase.inflate
import io.droidplate.androidbase.model.MovieItem
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var items = ArrayList<MovieItem>()
    var IMAGE_BASE_URL = " http://image.tmdb.org/t/p/w185//"

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder = ViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_movie)) {

        fun bind(items: MovieItem) {
            itemView.movie_title.text = items.movie_title
            itemView.movie_descr.text = items.movie_overview
            itemView.movie_count.text = items.movie_count

            Glide.with(itemView.context).load( IMAGE_BASE_URL + items.movie_poster)


        }
    }

    fun addItems(list: List<MovieItem>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }
}