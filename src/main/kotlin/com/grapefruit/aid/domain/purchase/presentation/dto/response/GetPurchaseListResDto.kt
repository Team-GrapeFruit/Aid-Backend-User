package com.grapefruit.aid.domain.purchase.presentation.dto.response

data class GetPurchaseListResDto(
    val purchaseId: Long,
    val quantity: Long,
    val purchaseList: List<SingleMenuResDto>
) {
    data class SingleMenuResDto(
        val menuId: Long,
        val menuName: String,
        val description: String,
        val menuImgUrl: String?
    )
}