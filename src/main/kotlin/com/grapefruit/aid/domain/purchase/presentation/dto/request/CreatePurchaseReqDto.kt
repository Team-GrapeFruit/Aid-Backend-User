package com.grapefruit.aid.domain.purchase.presentation.dto.request

import javax.validation.constraints.NotNull

data class CreatePurchaseReqDto(
    val menuListReqDto: List<MenuReqDto>
) {
    data class MenuReqDto(
        @field:NotNull
        val menuId: Long,
        @field:NotNull
        val quantity: Long
    )
}