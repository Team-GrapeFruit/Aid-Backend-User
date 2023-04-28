package com.grapefruit.aid.domain.menu.presentation.dto.response

import com.grapefruit.aid.domain.menu.entity.Menu

data class GetMenuDetailResDto(
    val menuName: String,
    val description: String,
    val cost: Long,
    val menuImgURL: String?
) {
    constructor(menu: Menu): this(
        menuName = menu.menuName,
        description = menu.description,
        cost = menu.cost,
        menuImgURL = menu.menuImgURL
    )
}