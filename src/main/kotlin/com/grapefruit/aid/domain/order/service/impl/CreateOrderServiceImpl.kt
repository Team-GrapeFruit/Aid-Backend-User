package com.grapefruit.aid.domain.order.service.impl

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.menu.exception.MenuNotFoundException
import com.grapefruit.aid.domain.menu.repository.MenuRepository
import com.grapefruit.aid.domain.order.entity.Order
import com.grapefruit.aid.domain.order.presentation.dto.MenuInfoDto
import com.grapefruit.aid.domain.order.presentation.dto.request.CreateOrderReqDto
import com.grapefruit.aid.domain.order.repository.OrderRepository
import com.grapefruit.aid.domain.order.service.CreateOrderService
import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CreateOrderServiceImpl(
    private val menuRepository: MenuRepository,
    private val orderRepository: OrderRepository,
    private val seatRepository: SeatRepository
): CreateOrderService {
    override fun execute(seatId: Long, createOrderReqDto: CreateOrderReqDto) {
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        val orders: List<Order> = createOrderReqDto.menusReqDto
            .map { MenuInfoDto(findMenu(it.menuId), it.quantity) }
            .map { Order(seat, it) }
        orderRepository.saveAll(orders)
    }

    private fun findMenu(menuId: Long): Menu =
        menuRepository.findByIdOrNull(menuId) ?: throw MenuNotFoundException()
}