package com.grapefruit.aid.domain.order.service

interface DeleteOrderService {
    fun execute(seatId: Long)
}