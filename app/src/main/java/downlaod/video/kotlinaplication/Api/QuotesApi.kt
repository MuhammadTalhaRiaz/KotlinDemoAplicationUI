package downlaod.video.kotlinaplication.Api

import downlaod.video.kotlinaplication.Models.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}