package com.grapefruit.aid.domain.order.service

import com.grapefruit.aid.domain.order.presentation.dto.request.CreateOrderReqDto

interface CreateOrderService {
    fun execute(storeId: Long, seatId: Long, createOrderReqDto: CreateOrderReqDto)
}