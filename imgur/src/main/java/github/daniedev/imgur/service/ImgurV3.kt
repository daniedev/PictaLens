package github.daniedev.imgur.service

import github.daniedev.imgur.model.gallery.GalleryResponse
import github.daniedev.imgur.model.gallerytags.GalleryTagsResponse
import github.daniedev.imgur.requestparams.Section
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurV3 {

    @GET("gallery/{section}")
    fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ) : Call<GalleryResponse>

    @GET("tags")
    fun getTags() : Call<GalleryTagsResponse>

}