package github.daniedev.imgur.model.gallerytags


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryTagsResponse(
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
)