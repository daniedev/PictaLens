package github.daniedev.pictalens.repository

import github.daniedev.imgur.ImgurManager
import github.daniedev.imgur.model.common.Image
import github.daniedev.imgur.model.common.Tag
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

    suspend fun getTags() : List<Tag>? {
        val response = imgurService.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getGalleryBasedOnTag(tagName : String) : List<Image>? {
        val response = imgurService.getTagGallery(tagName)
        return response.body()?.data?.images
    }
}