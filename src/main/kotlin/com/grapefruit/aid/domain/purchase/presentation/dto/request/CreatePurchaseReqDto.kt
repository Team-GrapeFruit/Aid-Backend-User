package com.grapefruit.aid.domain.purchase.presentation.dto.request

import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.validation.constraints.NotNull

data class CreatePurchaseReqDto(
    val menusReqDto: List<MenuReqDto>
): BaseIdEntity() {
    data class MenuReqDto(
        @field:NotNull
        val menuId: Long,
        @field:NotNull
        val quantity: Long
    )
}