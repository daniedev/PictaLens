package github.daniedev.imgur.service

import github.daniedev.imgur.ImgurManager
import github.daniedev.imgur.requestparams.Section
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurV3ServiceTest {

    private val imgurService: ImgurV3Service = ImgurManager.imgurService

    @Test
    fun `get tags returns Valid Response`() = runBlocking {
        val response = imgurService.getTags()
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get tag - science_and_tech returns Valid Response`() = runBlocking {
        val response = imgurService.getTagGallery("aww")
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery - hot returns Valid Response`() = runBlocking {
        val response = imgurService.getGallery(Section.HOT)
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get gallery - top returns Valid Response`() = runBlocking {
        val response = imgurService.getGallery(Section.TOP)
        println(response.raw().toString())
        assertNotNull(response.body())
    }
}