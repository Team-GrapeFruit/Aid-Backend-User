package com.grapefruit.aid.domain.menu.service

import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuDetailResDto

interface GetMenuDetailService {
    fun execute(menuId: Long): GetMenuDetailResDto
}