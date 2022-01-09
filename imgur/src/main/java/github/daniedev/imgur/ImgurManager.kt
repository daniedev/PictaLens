package github.daniedev.imgur

import github.daniedev.imgur.converter.EnumTypeConverterFactory
import github.daniedev.imgur.service.ImgurV3
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurManager {

    private const val API_KEY = "9a479b8077cf64f" //todo: remove key from imgur module

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request()
                    .newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY" )
                    .build()
                it.proceed(request)
            }
            .build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumTypeConverterFactory())
            .baseUrl("https://api.imgur.com/3/")
            .build()
    }

    val imgurService: ImgurV3 by lazy { retrofit.create(ImgurV3::class.java) }
}