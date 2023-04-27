package com.grapefruit.aid.domain.menu.presentation.dto.response

import com.grapefruit.aid.domain.menu.entity.Menu

data class GetMenuListResDto(
    val singleGetMenuResDto: List<SingleGetMenuResDto>
) {
    data class SingleGetMenuResDto(
        val menuId: Long,
        val menuName: String,
        val cost: Long,
        val description: String,
        val menuImgUrl: String?
    ) {
        constructor(menu: Menu) : this(
            menuId = menu.id,
            menuName = menu.menuName,
            cost = menu.cost,
            description = menu.description,
            menuImgUrl = menu.menuImgURL
        )
    }
}