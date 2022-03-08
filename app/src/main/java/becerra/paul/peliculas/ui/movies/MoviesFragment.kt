package becerra.paul.peliculas.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import becerra.paul.peliculas.Movie
import becerra.paul.peliculas.MovieAdapter
import becerra.paul.peliculas.R
import becerra.paul.peliculas.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
    var movies: ArrayList<Movie> = ArrayList()
    private var _binding: FragmentMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(MoviesViewModel::class.java)

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /**
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        addMockMovies()

        var adapter = MovieAdapter(root.context, movies)

        var listView: ListView = binding.listViewMovies

        listView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addMockMovies(){
        val movie1 = Movie(1, getString(R.string.movie1), getString(R.string.movie1_desc), 120, R.drawable.jackass)
        val movie2 = Movie(2,  getString(R.string.movie2), getString(R.string.movie2_desc), 60, R.drawable.jugarencasa)
        val movie3 = Movie(3,  getString(R.string.movie3), getString(R.string.movie3_desc), 100, R.drawable.monstermania)
        val movie4 = Movie(4,  getString(R.string.movie4), getString(R.string.movie4_desc), 110, R.drawable.queenpins)
        val movie5 = Movie(5,  getString(R.string.movie5), getString(R.string.movie5_desc), 90, R.drawable.quienesquien)
        val movie6 = Movie(6,  getString(R.string.movie6), getString(R.string.movie6_desc), 75, R.drawable.unbuclesinfin)
        movies.addAll(listOf(movie2,movie3, movie4, movie5, movie6, movie1))

    }
}