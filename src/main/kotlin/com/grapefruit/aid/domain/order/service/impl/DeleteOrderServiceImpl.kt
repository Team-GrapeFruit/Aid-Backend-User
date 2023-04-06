package com.grapefruit.aid.domain.order.service.impl

import com.grapefruit.aid.domain.order.entity.Order
import com.grapefruit.aid.domain.order.repository.OrderRepository
import com.grapefruit.aid.domain.order.service.DeleteOrderService
import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class DeleteOrderServiceImpl(
    private val seatRepository: SeatRepository,
    private val orderRepository: OrderRepository
): DeleteOrderService {
    override fun execute(seatId: Long) {
        orderRepository.deleteAll(findOrder(seatId))
    }

    private fun findOrder(seatId: Long): List<Order> {
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        return orderRepository.findAllBySeat(seat)
    }

}