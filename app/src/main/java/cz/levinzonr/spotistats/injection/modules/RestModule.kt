package cz.levinzonr.spotistats.injection.modules

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import cz.levinzonr.spotistats.BuildConfig
import cz.levinzonr.spotistats.network.Api
import cz.levinzonr.spotistats.network.util.DateDeserializer
import cz.levinzonr.spotistats.network.util.ItemTypeAdapterFactory
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


val restModule = module {



    single<TypeAdapterFactory> { ItemTypeAdapterFactory() }


    single {
        GsonBuilder()
                .registerTypeAdapterFactory(ItemTypeAdapterFactory())
                .registerTypeAdapter(Date::class.java, DateDeserializer())
                .setDateFormat(DateDeserializer.DATE_FORMATS[0])
                .create()
    }


    single {

        val clientBuilder = OkHttpClient.Builder()
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                //.addInterceptor(AuthTokenInterceptor(get()))
                .authenticator(get())
        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            clientBuilder.addInterceptor(logger)
        }

        clientBuilder.build()
    }




    single {
        get<Retrofit>().create<Api>(Api::class.java)
    }



    // Retrofit
    single {
        Retrofit.Builder()
                .client(get())
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }

}