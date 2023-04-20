package com.grapefruit.aid.domain.menu.service

import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuListResDto

interface GetMenuListService {
    fun execute(storeId: Long): List<GetMenuListResDto>
}