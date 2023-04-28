package com.grapefruit.aid.domain.menu.presentation.dto.response

import com.grapefruit.aid.domain.menu.entity.Menu

data class GetMenuByCategoryResDto(
    val menuId: Long,
    val menuName: String,
    val cost: Long,
    val menuImgUrl: String?
) {
    constructor(menu: Menu): this(
        menuId = menu.id,
        menuName = menu.menuName,
        cost = menu.cost,
        menuImgUrl = menu.menuImgURL
    )
}