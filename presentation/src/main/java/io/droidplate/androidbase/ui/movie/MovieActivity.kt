package io.droidplate.androidbase.ui.movie

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.droidplate.androidbase.*
import io.droidplate.androidbase.model.MovieItem
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val movieAdapter = MovieAdapter()

    val query = "en-US"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppInjector().inject(this)


        initViews()

        withViewModel<MovieViewModel>(viewModelFactory) {
            getMovie(refresh = true, query = query)
            observe(movies, ::updateMovies)
        }

    }

    /**
     * Views initialization
     */
    fun initViews() {

        with(moviesRecyclerView) {
            adapter = movieAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MovieActivity)
        }
    }

    /**
     * adapter databinding
     * @param data [post list from the data layer]
     */
    private fun updateMovies(data: Data<List<MovieItem>>?) {
        data?.let {
            when (it.dataState) {
                DataState.LOADING -> progressBar2.showProgress()
                DataState.SUCCESS -> progressBar2.hideProgress()
                DataState.ERROR -> progressBar2.hideProgress()
            }
            it.data?.let { movieAdapter.addItems(it) }
            it.message?.let { toast(it, this@MovieActivity) }
        }
    }
}
