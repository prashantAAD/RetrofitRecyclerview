package www.revengerfitness.blogspot.com.retrofitrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import www.revengerfitness.blogspot.com.retrofitbasicapp.model.Article
import www.revengerfitness.blogspot.com.retrofitrecyclerview.R

/**
 * adapter takes data and context.
 * adapter extends Adapter class in which it takes inner class of view holder. */
//class MyAdapter(private val songs: List<String>):
class NewsAdapter(private val context: Context, private val articles: List<Article>) :// val should used with properties.otherwise those are parameters.
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    /**
     * its a nested class*/
    class ArticleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        // it takes view as parameter and extend with ViewHolder class
// stores references of views in view holder class
        var newsImage: ImageView = itemView.findViewById(R.id.newsImage)
        var newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        var newsDescription: TextView = itemView.findViewById(R.id.newsDescription)
        var container: LinearLayout = itemView.findViewById<LinearLayout>(R.id.container)

    }

    /**
     * create view holder and store views.
     * layout inflater converts xml view which is item_view into java object.*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context) // create layout inflater object
        val view = inflater.inflate(R.layout.item_layout, parent, false) // create view
        return ArticleViewHolder(view) // stores views in view holder ArticleViewHolder(itemView: View) and return it

    }

    /**
     * it use to bind data in views hold by view holder and it takes holder and position */
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=articles[position]
        // holder.newsTitle.text=songs[position]
        holder.newsTitle.text = article.title // Song object
        // holder.newsDescription.text=songs[position]
        holder.newsDescription.text = article.description
      /**  // passing color to recycle view
        var color = "#CCCCCC"
        if (position % 2 == 0) {
            color = "#EEEEEE"
        }
        holder.container.setBackgroundColor(Color.parseColor(color))
      */
        Glide.with(context).load(article.urlToImage).into(holder.newsImage) // showing image with glide
        holder.itemView.setOnClickListener {
            Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int { // it tells us about no of items going to show in recycler view.
        return articles.size
    }

}

