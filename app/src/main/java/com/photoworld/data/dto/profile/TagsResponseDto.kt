package com.photoworld.data.dto.profile

import com.google.gson.annotations.SerializedName

data class TagsResponseDto(
    @SerializedName("tags")
    val tags: List<String>,
)