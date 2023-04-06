package com.grapefruit.aid.domain.menu.presentation.dto.response

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.seat.entity.Seat

data class SingleMenuListResDto(
    val menuId: Long,
    val menuName: String,
    val description: String,
    val menuImgUrl: String?
) {
    constructor(menu: Menu): this(
        menuId = menu.id,
        menuName = menu.menuName,
        description = menu.description,
        menuImgUrl = menu.menuImgURL
    )
}