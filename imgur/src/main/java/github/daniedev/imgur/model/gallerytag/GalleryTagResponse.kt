package github.daniedev.imgur.model.gallerytag


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import github.daniedev.imgur.model.common.Tag

@JsonClass(generateAdapter = true)
data class GalleryTagResponse(
    @Json(name = "data")
    val `data`: Tag?,
    @Json(name = "status")
    val status: Int?,
    @Json(name = "success")
    val success: Boolean?
)