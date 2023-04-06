package com.grapefruit.aid.domain.order.presentation

import com.grapefruit.aid.domain.order.presentation.dto.request.CreateOrderReqDto
import com.grapefruit.aid.domain.order.service.CreateOrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/order")
class OrderController(
    private val createOrderService: CreateOrderService
) {
    @PostMapping
    fun createOrder(@RequestParam storeId: Long,
                    @RequestParam seatId: Long,
                    @RequestBody @Valid createOrderReqDto: CreateOrderReqDto): ResponseEntity<Void> {
        createOrderService.execute(storeId, seatId, createOrderReqDto)
        return ResponseEntity(HttpStatus.CREATED)
    }
}