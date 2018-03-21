package app.rashi.com.sample_movie_app.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.rashi.com.sample_movie_app.R
import app.rashi.com.sample_movie_app.data.db.entities.Movie
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

class MovieAdapter(var context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(), AutoUpdatableAdapter {

    lateinit var movieClickListener: (it: Movie)->Unit

    var movieList: List<Movie> by Delegates.observable(emptyList()) {
        _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
            MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_thumb, null, false))

    override fun getItemCount(): Int = movieList.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList.get(position))
        holder.v.setOnClickListener {
            movieClickListener(movieList[position])
        }
    }

    inner class MovieViewHolder(var v: View) : RecyclerView.ViewHolder(v) {
        var titleView: TextView = v.findViewById(R.id.textView)
        var posterView: ImageView = v.findViewById(R.id.movie_poster)

        fun bind(movieItem: Movie) {
            titleView.text = movieItem.title
            Picasso.with(context).load("http://image.tmdb.org/t/p/w342/${movieItem.poster_path}").into(posterView)
        }
    }
}