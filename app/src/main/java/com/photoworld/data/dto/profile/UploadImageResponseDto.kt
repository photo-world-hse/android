package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class UploadImageResponseDto(
    @SerializedName("imageUrl")
    val imageUrl: String?,
)
