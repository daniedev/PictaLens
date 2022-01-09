package github.daniedev.imgur.service

import github.daniedev.imgur.ImgurManager
import github.daniedev.imgur.requestparams.Section
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ImgurV3Test {

    private val imgurService: ImgurV3 = ImgurManager.imgurService

    @Test
    fun `get tags returns Valid Response`() {
        val response = imgurService.getTags().execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery - hot returns Valid Response`() {
        val response = imgurService.getGallery(Section.HOT).execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery - top returns Valid Response`() {
        val response = imgurService.getGallery(Section.TOP).execute()
        println(response.raw().toString())
        assertNotNull(response.body())
    }


}