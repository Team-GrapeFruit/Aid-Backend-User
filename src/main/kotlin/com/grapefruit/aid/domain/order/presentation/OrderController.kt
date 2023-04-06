package com.grapefruit.aid.domain.order.presentation

import com.grapefruit.aid.domain.order.entity.Order
import com.grapefruit.aid.domain.order.presentation.dto.request.CreateOrderReqDto
import com.grapefruit.aid.domain.order.service.CreateOrderService
import com.grapefruit.aid.domain.order.service.DeleteOrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/order")
class OrderController(
    private val createOrderService: CreateOrderService,
    private val deleteOrderService: DeleteOrderService
) {
    @PostMapping("/{seat_id}")
    fun createOrder(@PathVariable("seat_id") seatId: Long,
                    @RequestBody @Valid createOrderReqDto: CreateOrderReqDto): ResponseEntity<Void> {
        createOrderService.execute(seatId, createOrderReqDto)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{seat_id}")
    fun deleteOrder(@PathVariable("seat_id") seatId: Long): ResponseEntity<Void> {
        deleteOrderService.execute(seatId)
        return ResponseEntity.noContent().build()
    }
}