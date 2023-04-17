package com.grapefruit.aid.domain.purchase.presentation.dto.response

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.purchase.entity.Purchase

data class GetPurchaseResDto(
    val purchaseId: Long,
    val quantity: Long,
    val purchaseMenu: MenuResDto
) {
    data class MenuResDto(
        val menuId: Long,
        val menuName: String,
        val cost: Long,
        val description: String,
        val menuImgUrl: String?
    ) {
        constructor(menu: Menu): this(
            menuId = menu.id,
            menuName = menu.menuName,
            cost = menu.cost,
            description = menu.description,
            menuImgUrl = menu.menuImgURL
        )
    }

    constructor(purchase: Purchase): this(
        purchaseId = purchase.id,
        quantity = purchase.quantity,
        purchaseMenu = MenuResDto(purchase.menu)
    )
}