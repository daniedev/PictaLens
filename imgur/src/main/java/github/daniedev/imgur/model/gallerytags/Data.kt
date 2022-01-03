package github.daniedev.imgur.model.gallerytags


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "featured")
    val featured: String?,
    @Json(name = "galleries")
    val galleries: List<Gallery>,
    @Json(name = "tags")
    val tags: List<TagX>
)