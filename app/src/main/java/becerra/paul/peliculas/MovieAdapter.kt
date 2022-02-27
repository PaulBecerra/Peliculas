package becerra.paul.peliculas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter: BaseAdapter {

    lateinit var context: Context
    private var movies = ArrayList<Movie>()

    constructor(context: Context, movies: ArrayList<Movie>){
        this.context = context
        this.movies = movies
    }

    /**
     * Return size of the list
     */
    override fun getCount(): Int {
        return movies.size
    }

    /**
     * return item by index
     */
    override fun getItem(p0: Int): Any {
        return movies[p0]
    }

    /**
     * Return id of item
     */
    override fun getItemId(p0: Int): Long {
        // pide el id del elemento
        return p0.toLong()
    }

    /**
     * return movie view with image and movie text
     */
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // obtener un inflador
        val layoutInflanter = LayoutInflater.from(context)
        var view = layoutInflanter.inflate(R.layout.movie_view, null)

        var imageView: ImageView = view.findViewById(R.id.imageView)
        var textViewMovieName: TextView = view.findViewById(R.id.textViewMovieName)
        var textViewMovieDuration: TextView = view.findViewById(R.id.textViewMovieDuration)

        var movie: Movie = movies[p0]

        imageView.setImageResource(movie.image)
        textViewMovieName.setText(movie.name)
        textViewMovieDuration.setText("${movie.duration} min")

        return view

    }
}