package com.grapefruit.aid.domain.purchase.presentation

import com.grapefruit.aid.domain.purchase.presentation.dto.request.CreatePurchaseReqDto
import com.grapefruit.aid.domain.purchase.presentation.dto.response.GetPurchaseResDto
import com.grapefruit.aid.domain.purchase.service.CreatePurchaseService
import com.grapefruit.aid.domain.purchase.service.DeleteMenuFromPurchaseService
import com.grapefruit.aid.domain.purchase.service.DeletePurchaseService
import com.grapefruit.aid.domain.purchase.service.GetPurchaseListService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val createPurchaseService: CreatePurchaseService,
    private val deletePurchaseService: DeletePurchaseService,
    private val deleteMenuFromPurchaseService: DeleteMenuFromPurchaseService,
    private val getPurchaseListService: GetPurchaseListService
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

    @DeleteMapping("/food/{purchase_id}")
    fun deleteMenuFromPurchase(@PathVariable("purchase_id") purchaseId: Long): ResponseEntity<Void> {
        deleteMenuFromPurchaseService.execute(purchaseId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{seat_id}")
    fun getPurchaseList(@PathVariable("seat_id") seatId: Long): ResponseEntity<List<GetPurchaseResDto>> {
        val result = getPurchaseListService.execute(seatId)
        return ResponseEntity.ok(result)
    }
}