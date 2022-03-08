package becerra.paul.peliculas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import becerra.paul.peliculas.Movie
import becerra.paul.peliculas.MovieAdapter
import becerra.paul.peliculas.R
import becerra.paul.peliculas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    var series: ArrayList<Movie> = ArrayList()
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /**
        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        addMockSeries()

        var adapter = MovieAdapter(root.context, series)

        var listView: ListView = binding.listViewSeries

        listView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addMockSeries(){
        val movie1 = Movie(1, getString(R.string.movie1), getString(R.string.movie1_desc), 120, R.drawable.jackass)
        val movie2 = Movie(2,  getString(R.string.movie2), getString(R.string.movie2_desc), 60, R.drawable.jugarencasa)
        val movie3 = Movie(3,  getString(R.string.movie3), getString(R.string.movie3_desc), 100, R.drawable.monstermania)
        val movie4 = Movie(4,  getString(R.string.movie4), getString(R.string.movie4_desc), 110, R.drawable.queenpins)
        val movie5 = Movie(5,  getString(R.string.movie5), getString(R.string.movie5_desc), 90, R.drawable.quienesquien)
        val movie6 = Movie(6,  getString(R.string.movie6), getString(R.string.movie6_desc), 75, R.drawable.unbuclesinfin)
        series.addAll(listOf(movie1, movie2,movie3, movie4, movie5, movie6))
    }
}