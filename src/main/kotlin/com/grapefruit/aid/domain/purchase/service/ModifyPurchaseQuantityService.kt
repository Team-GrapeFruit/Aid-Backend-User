package com.grapefruit.aid.domain.purchase.service

import com.grapefruit.aid.domain.purchase.presentation.dto.request.ModifyPurchaseQuantityReqDto

interface ModifyPurchaseQuantityService {
    fun execute(purchaseId: Long, modifyPurchaseQuantityReqDto: ModifyPurchaseQuantityReqDto)
}