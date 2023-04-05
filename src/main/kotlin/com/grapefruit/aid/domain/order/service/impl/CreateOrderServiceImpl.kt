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
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.repository.StoreRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class CreateOrderServiceImpl(
    private val menuRepository: MenuRepository,
    private val orderRepository: OrderRepository,
    private val seatRepository: SeatRepository,
    private val storeRepository: StoreRepository
): CreateOrderService {
    override fun execute(storeId: Long, seatId: Long, createOrderReqDto: CreateOrderReqDto) {
        val store: Store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        createOrderReqDto.menusReqDto
            .map {
                val dto = MenuInfoDto(menuRepository.findByIdOrNull(it.menuId) ?: throw MenuNotFoundException(), it.quantity)
                val order = Order(store, seat, dto)
                orderRepository.save(order)
            }

    }
}