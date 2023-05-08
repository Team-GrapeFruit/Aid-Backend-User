package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.purchase.entity.Purchase
import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.DeletePurchaseService
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.repository.StoreRepository
import org.springframework.data.repository.findByIdOrNull

class DeletePurchaseServiceImpl(
    private val seatRepository: SeatRepository,
    private val purchaseRepository: PurchaseRepository
): DeletePurchaseService {
    override fun execute(seatId: Long) {
        val seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        val purchases = purchaseRepository.findAllBySeat(seat)
        purchaseRepository.deleteAll(purchases)
    }

}