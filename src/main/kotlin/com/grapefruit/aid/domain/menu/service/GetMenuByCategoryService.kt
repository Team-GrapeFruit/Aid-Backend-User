package com.grapefruit.aid.domain.menu.service

import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuByCategoryResDto

interface GetMenuByCategoryService {
    fun execute(categoryId: Long): List<GetMenuByCategoryResDto>
}