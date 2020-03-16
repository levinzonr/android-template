package cz.levinzonr.spotistats.network

import cz.levinzonr.spotistats.domain.models.Post
import cz.levinzonr.spotistats.domain.repository.PostRepository
import cz.levinzonr.spotistats.domain.repository.RepositoryException

class RestPostRepository(private val api: Api) : PostRepository {
    @Throws(RepositoryException::class)
    override suspend fun getPosts(cached: Boolean): List<Post> {
        val response = api.getPosts()
        if (response.isSuccessful) {
            return response.body()
                ?: throw(RepositoryException(
                        response.code(),
                        response.errorBody()?.string(),
                        response.message()
                ))
        } else {
            throw(RepositoryException(
                    response.code(),
                    response.errorBody()?.string(),
                    response.message()
            ))
        }
    }
}