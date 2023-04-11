package com.grapefruit.aid.domain.purchase.repository

import com.grapefruit.aid.domain.purchase.entity.Purchase
import com.grapefruit.aid.domain.seat.entity.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository: JpaRepository<Purchase, Long> {
    fun findAllBySeat(seat: Seat): List<Purchase>
}