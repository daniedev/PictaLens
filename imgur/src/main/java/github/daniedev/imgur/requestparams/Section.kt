package github.daniedev.imgur.requestparams

import com.squareup.moshi.Json

enum class Section {
    @Json(name = "hot")
    HOT,

    @Json(name = "top")
    TOP
}