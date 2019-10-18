package cz.levinzonr.spotistats.network.token

import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor() : Interceptor {

    /**
     * Actual method where the interception takes place
     * @param chain current chain of requests
     */
    override fun intercept(chain: Interceptor.Chain): Response {

        val request =
                chain.request()
                        .newBuilder()
                        .header("Authorization", "Bearer ").build()
        return chain.proceed(request)
    }
}