package becerra.paul.peliculas.ui.slideshow

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
import becerra.paul.peliculas.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {
    var favs: ArrayList<Movie> = ArrayList()
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /**
        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        addMockFavs()

        var adapter = MovieAdapter(root.context, favs)

        var listView: ListView = binding.listViewFavs

        listView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addMockFavs(){
        val favs1 = Movie(1, getString(R.string.movie1), getString(R.string.movie1_desc), 120, R.drawable.jackass)
        val favs2 = Movie(2,  getString(R.string.serie2), getString(R.string.serie2_desc), 60, R.drawable.space_force)
        val favs3 = Movie(3,  getString(R.string.movie3), getString(R.string.movie3_desc), 100, R.drawable.monstermania)
        val favs4 = Movie(4,  getString(R.string.serie4), getString(R.string.serie4_desc), 110, R.drawable.and_just_like_that)
        val favs5 = Movie(5,  getString(R.string.movie5), getString(R.string.movie5_desc), 90, R.drawable.quienesquien)
        val favs6 = Movie(6,  getString(R.string.serie6), getString(R.string.serie6_desc), 75, R.drawable.pam_tommy)
        favs.addAll(listOf(favs1, favs2,favs3, favs4, favs5, favs6))
    }
}