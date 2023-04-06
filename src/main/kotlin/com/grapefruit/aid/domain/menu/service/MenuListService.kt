package com.grapefruit.aid.domain.menu.service

import com.grapefruit.aid.domain.menu.presentation.dto.response.SingleMenuListResDto

interface MenuListService {
    fun execute(storeId: Long): List<SingleMenuListResDto>
}