package github.daniedev.imgur.model.gallerytags


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import github.daniedev.imgur.model.common.Image

@JsonClass(generateAdapter = true)
data class Gallery(
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "topPost")
    val topPost: Image
)