package com.grapefruit.aid.domain.store.presentation

import com.grapefruit.aid.domain.store.presentation.dto.response.StoreDetailResDto
import com.grapefruit.aid.domain.store.service.StoreDetailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/store")
class StoreController(
    private val storeDetailService: StoreDetailService
) {
    @GetMapping("/{id}")
    fun storeDetail(@PathVariable("id") storeId: Long): ResponseEntity<StoreDetailResDto> {
        val result: StoreDetailResDto = storeDetailService.execute(storeId)
        return ResponseEntity.ok(result)
    }
}