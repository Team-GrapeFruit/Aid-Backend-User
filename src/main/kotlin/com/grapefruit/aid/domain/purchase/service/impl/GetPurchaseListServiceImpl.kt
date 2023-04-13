package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.purchase.entity.Purchase
import com.grapefruit.aid.domain.purchase.presentation.dto.response.GetPurchaseResDto
import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.GetPurchaseListService
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetPurchaseListServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val seatRepository: SeatRepository
): GetPurchaseListService {
    override fun execute(seatId: Long): List<GetPurchaseResDto> {
        val seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        val purchases: List<Purchase> = purchaseRepository.findAllBySeat(seat)

        return purchases.map {
                GetPurchaseResDto(it)
        }
    }
}