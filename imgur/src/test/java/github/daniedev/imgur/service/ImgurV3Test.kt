package github.daniedev.imgur.service

import junit.framework.Assert.assertNotNull
import okhttp3.OkHttpClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurV3Test {

    private val client = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("Authorization", "Client-ID 9a479b8077cf64f" )
                .build()
            it.proceed(request)
        }
        .build()


    private val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()

    private val imgurService = retrofit.create(ImgurV3::class.java)

    @Test
    fun `get tags returns Valid Response`() {
        val response = imgurService.getTags().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery returns Valid Response`() {
        val response = imgurService.getGallery().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }


}