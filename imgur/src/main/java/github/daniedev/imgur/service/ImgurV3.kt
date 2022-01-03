package github.daniedev.imgur.service

import github.daniedev.imgur.model.gallery.GalleryResponse
import github.daniedev.imgur.model.gallerytags.GalleryTagsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurV3 {

    @GET("gallery/hot?album_previews=true")
    fun getGallery() : Call<GalleryResponse>

    @GET("tags")
    fun getTags() : Call<GalleryTagsResponse>

}