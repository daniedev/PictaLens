package github.daniedev.imgur.model.gallery


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryResponse(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
)