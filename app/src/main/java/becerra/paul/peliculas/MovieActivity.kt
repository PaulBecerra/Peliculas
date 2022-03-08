package becerra.paul.peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val textViewName: TextView = findViewById(R.id.textViewMovieNameActivity)
        val textViewSynopsis: TextView = findViewById(R.id.textViewMovieDescription)
        val imageViewImage: ImageView = findViewById(R.id.imageViewMovie)

        val bundle = intent.extras

        if (bundle != null) {
            val name = bundle.getString("name")
            val synopsis = bundle.getString("synopsis")
            val image = bundle.getInt("image")

            textViewName.setText(name)
            textViewSynopsis.setText(synopsis)
            imageViewImage.setImageResource(image)
        }
    }
}