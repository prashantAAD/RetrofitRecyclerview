package www.revengerfitness.blogspot.com.retrofitrecyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.revengerfitness.blogspot.com.retrofitbasicapp.model.News
import www.revengerfitness.blogspot.com.retrofitbasicapp.repository.NewsService
import www.revengerfitness.blogspot.com.retrofitrecyclerview.R
import www.revengerfitness.blogspot.com.retrofitrecyclerview.adapter.NewsAdapter
import www.revengerfitness.blogspot.com.retrofitrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
       getNews()

    }
    private fun getNews() {
        // NewsService is a object.
        // singleton object of NewsInterface.
        // getHeadlines abstract function of interface.
        val news: Call<News> = NewsService.newsInstance.getHeadlines("in", 1)
        // enqueue is abstract method used to pass retrofit callback
        news.enqueue(object : Callback<News> {// In retrofit we put all the request in a queue and retrofit process it one by one.once a request complete then a callback of it called and similar for other requests.
        override fun onFailure(call: Call<News>, t: Throwable) {
            Log.d("prashant chauhan", "error in fetching news", t)
        }



            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {

                    Log.d("prashant chauhan",news.toString())
                    adapter=NewsAdapter(this@MainActivity,news.articles)
                    binding.newsList.adapter=adapter
                    binding.newsList.layoutManager=LinearLayoutManager(this@MainActivity)


                }
            }


        })
    }
}