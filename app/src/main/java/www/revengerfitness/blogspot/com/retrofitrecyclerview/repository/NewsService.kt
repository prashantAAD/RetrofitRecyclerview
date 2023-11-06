package www.revengerfitness.blogspot.com.retrofitbasicapp.repository

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import www.revengerfitness.blogspot.com.retrofitbasicapp.model.News

//https://newsapi.org/v2/everything?q=apple&from=2022-09-22&to=2022-09-22&sortBy=popularity&apiKey=API_KEY
//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY

const val BASE_URL="https://newsapi.org/"
const val API_KEY="b9729c9ec0d1454b84d48c44a969232d"
interface NewsInterface {
    // whereever we use this end point or getHeadlines()  abstract function
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String, @Query("page") page:Int) :Call<News> // retrofit callback with News class return News object.call<> is a retrofit interface.


// https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1
}
object NewsService{
val newsInstance: NewsInterface // implement NewsInterface and make instance or object inside object body.
init {
    // retrofit singleton object creation
    val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // now tell retrofit to give implementation of interface
    newsInstance =retrofit.create(NewsInterface::class.java)


}
}



