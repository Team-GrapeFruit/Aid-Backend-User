package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.menu.exception.MenuNotFoundException
import com.grapefruit.aid.domain.menu.repository.MenuRepository
import com.grapefruit.aid.domain.purchase.entity.Purchase
import com.grapefruit.aid.domain.purchase.presentation.dto.MenuInfoDto
import com.grapefruit.aid.domain.purchase.presentation.dto.request.CreatePurchaseReqDto
import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.CreatePurchaseService
import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CreatePurchaseServiceImpl(
    private val menuRepository: MenuRepository,
    private val purchaseRepository: PurchaseRepository,
    private val seatRepository: SeatRepository
): CreatePurchaseService {
    override fun execute(seatId: Long, createPurchaseReqDto: CreatePurchaseReqDto) {
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        val purchases: List<Purchase> = createPurchaseReqDto.menusReqDto
            .map { MenuInfoDto(findMenu(it.menuId), it.quantity) }
            .map { Purchase(seat, it) }
        purchaseRepository.saveAll(purchases)
    }

    private fun findMenu(menuId: Long): Menu =
        menuRepository.findByIdOrNull(menuId) ?: throw MenuNotFoundException()
}