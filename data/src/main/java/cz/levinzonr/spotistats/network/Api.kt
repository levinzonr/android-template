package cz.levinzonr.spotistats.network

import cz.levinzonr.spotistats.domain.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>


}
