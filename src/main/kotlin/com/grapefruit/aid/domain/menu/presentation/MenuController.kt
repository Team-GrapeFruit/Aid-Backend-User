package com.grapefruit.aid.domain.menu.presentation

import com.grapefruit.aid.domain.menu.presentation.dto.response.SingleMenuListResDto
import com.grapefruit.aid.domain.menu.service.MenuListService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MenuController(
    private val menuListService: MenuListService
) {
    @GetMapping("/{store_id}")
    fun getMenuList(@PathVariable("store_id") storeId: Long): ResponseEntity<List<SingleMenuListResDto>> {
        val result: List<SingleMenuListResDto> = menuListService.execute(storeId)
        return ResponseEntity.ok(result)
    }
}