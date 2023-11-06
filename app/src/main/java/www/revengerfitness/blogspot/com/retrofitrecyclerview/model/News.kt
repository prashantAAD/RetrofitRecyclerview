package www.revengerfitness.blogspot.com.retrofitbasicapp.model

import www.revengerfitness.blogspot.com.retrofitbasicapp.model.Article

data class News(val totalResults:Int,val articles:List<Article>) {// properties name should match with json
}