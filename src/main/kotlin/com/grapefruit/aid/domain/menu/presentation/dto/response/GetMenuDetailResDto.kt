package com.grapefruit.aid.domain.menu.presentation.dto.response

data class GetMenuDetailResDto(
    val menuName: String,
    val description: String,
    val cost: Long,
    val menuImgURL: String?
)