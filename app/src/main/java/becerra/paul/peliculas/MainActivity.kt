package becerra.paul.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    var movies: ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMockMovies()

        var adapter = MovieAdapter(this, movies)

        var listView: ListView = findViewById(R.id.listView)

        listView.adapter = adapter
    }

    private fun addMockMovies(){
            val movie1 = Movie(1, getString(R.string.movie1), getString(R.string.movie1_desc), 120,R.drawable.jackass)
            val movie2 = Movie(2,  getString(R.string.movie2), getString(R.string.movie2_desc), 60,R.drawable.jugarencasa)
            val movie3 = Movie(3,  getString(R.string.movie3), getString(R.string.movie3_desc), 100,R.drawable.monstermania)
            val movie4 = Movie(4,  getString(R.string.movie4), getString(R.string.movie4_desc), 110,R.drawable.queenpins)
            val movie5 = Movie(5,  getString(R.string.movie5), getString(R.string.movie5_desc), 90,R.drawable.quienesquien)
            val movie6 = Movie(6,  getString(R.string.movie6), getString(R.string.movie6_desc), 75,R.drawable.unbuclesinfin)
            movies.addAll(listOf(movie1, movie2,movie3, movie4, movie5, movie6))

    }
}