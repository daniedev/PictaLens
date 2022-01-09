package github.daniedev.imgur.service

import github.daniedev.imgur.model.gallery.GalleryResponse
import github.daniedev.imgur.model.gallerytags.GalleryTagsResponse
import github.daniedev.imgur.requestparams.Section
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurV3Service {

    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ) : Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags() : Response<GalleryTagsResponse>

}