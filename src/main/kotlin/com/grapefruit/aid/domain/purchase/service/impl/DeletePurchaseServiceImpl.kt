package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.DeletePurchaseService
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
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