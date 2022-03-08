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
        val serie1 = Movie(1, getString(R.string.serie1), getString(R.string.serie1_desc), 120, R.drawable.the_guardians_of_justice)
        val serie2 = Movie(2,  getString(R.string.serie2), getString(R.string.serie2_desc), 60, R.drawable.space_force)
        val serie3 = Movie(3,  getString(R.string.serie3), getString(R.string.serie3_desc), 100, R.drawable.disenchantment)
        val serie4 = Movie(4,  getString(R.string.serie4), getString(R.string.serie4_desc), 110, R.drawable.and_just_like_that)
        val serie5 = Movie(5,  getString(R.string.serie5), getString(R.string.serie5_desc), 90, R.drawable.my_dress_up_darling)
        val serie6 = Movie(6,  getString(R.string.serie6), getString(R.string.serie6_desc), 75, R.drawable.pam_tommy)
        series.addAll(listOf(serie1, serie2,serie3, serie4, serie5, serie6))
    }
}