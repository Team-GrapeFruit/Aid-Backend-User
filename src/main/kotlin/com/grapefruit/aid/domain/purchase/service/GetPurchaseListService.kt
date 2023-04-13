package com.grapefruit.aid.domain.purchase.service

import com.grapefruit.aid.domain.purchase.presentation.dto.response.GetPurchaseResDto

interface GetPurchaseListService {
    fun execute(seatId: Long): List<GetPurchaseResDto>
}