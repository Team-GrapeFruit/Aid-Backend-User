package com.grapefruit.aid.domain.menu.presentation

import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuByCategoryResDto
import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuDetailResDto
import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuListResDto
import com.grapefruit.aid.domain.menu.service.GetMenuByCategoryService
import com.grapefruit.aid.domain.menu.service.GetMenuDetailService
import com.grapefruit.aid.domain.menu.service.GetMenuListService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MenuController(
    private val getMenuListService: GetMenuListService,
    private val getMenuByCategoryService: GetMenuByCategoryService,
    private val getMenuDetailService: GetMenuDetailService
) {
    @GetMapping("/{store_id}")
    fun getMenuList(@PathVariable("store_id") storeId: Long): ResponseEntity<List<GetMenuListResDto>> {
        val result: List<GetMenuListResDto> = getMenuListService.execute(storeId)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/category/{category_id}")
    fun getMenuByCategory(@PathVariable("category_id") categoryId: Long): ResponseEntity<List<GetMenuByCategoryResDto>> {
        val result: List<GetMenuByCategoryResDto> = getMenuByCategoryService.execute(categoryId)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/detail/{menu_id}")
    fun getMenuDetail(@PathVariable("menu_id") menuId: Long): ResponseEntity<GetMenuDetailResDto> {
        val result: GetMenuDetailResDto = getMenuDetailService.execute(menuId)
        return ResponseEntity.ok(result)

    }
}