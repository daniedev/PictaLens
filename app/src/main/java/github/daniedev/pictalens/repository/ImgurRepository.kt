package github.daniedev.pictalens.repository

import github.daniedev.imgur.ImgurManager
import github.daniedev.imgur.model.gallery.Data
import github.daniedev.imgur.requestparams.Section

class ImgurRepository {

    private val imgurService = ImgurManager.imgurService

    suspend fun getHotFeed(): List<Data>? {
       val response = imgurService.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Data>? {
        val response = imgurService.getGallery(Section.TOP)
        return response.body()?.data
    }
}