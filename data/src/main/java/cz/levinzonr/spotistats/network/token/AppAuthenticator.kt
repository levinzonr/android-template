package cz.levinzonr.spotistats.network.token

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.KoinComponent


class AppAuthenticator() : Authenticator, KoinComponent {


    override fun authenticate(route: Route?, response: Response): Request? {

            return response.request().newBuilder()
                    .header("Authorization", "Bearer ")
                    .build()

    }

}