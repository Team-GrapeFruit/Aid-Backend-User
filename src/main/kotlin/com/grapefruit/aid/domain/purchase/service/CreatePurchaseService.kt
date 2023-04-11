package com.grapefruit.aid.domain.purchase.service

import com.grapefruit.aid.domain.purchase.presentation.dto.request.CreatePurchaseReqDto

interface CreatePurchaseService {
    fun execute(seatId: Long, createPurchaseReqDto: CreatePurchaseReqDto)
}