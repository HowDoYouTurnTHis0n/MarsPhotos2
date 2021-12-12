package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String, @Json(name = "imageUrl") val imageUrl: String
)