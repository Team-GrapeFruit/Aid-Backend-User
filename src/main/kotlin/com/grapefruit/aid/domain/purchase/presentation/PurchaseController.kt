package com.grapefruit.aid.domain.purchase.presentation

import com.grapefruit.aid.domain.purchase.presentation.dto.request.CreatePurchaseReqDto
import com.grapefruit.aid.domain.purchase.service.CreatePurchaseService
import com.grapefruit.aid.domain.purchase.service.DeletePurchaseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val createPurchaseService: CreatePurchaseService,
    private val deletePurchaseService: DeletePurchaseService
) {
    @PostMapping("/{seat_id}")
    fun createOrder(@PathVariable("seat_id") seatId: Long,
                    @RequestBody @Valid createPurchaseReqDto: CreatePurchaseReqDto): ResponseEntity<Void> {
        createPurchaseService.execute(seatId, createPurchaseReqDto)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/{seat_id}")
    fun deleteOrder(@PathVariable("seat_id") seatId: Long): ResponseEntity<Void> {
        deletePurchaseService.execute(seatId)
        return ResponseEntity.noContent().build()
    }
}