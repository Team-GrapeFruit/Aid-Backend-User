package com.grapefruit.aid.domain.order.repository

import com.grapefruit.aid.domain.order.entity.Order
import com.grapefruit.aid.domain.seat.entity.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
    fun findAllBySeat(seat: Seat): List<Order>
}