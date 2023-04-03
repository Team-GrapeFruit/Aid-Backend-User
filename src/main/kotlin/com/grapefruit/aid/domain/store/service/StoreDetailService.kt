package com.grapefruit.aid.domain.store.service

import com.grapefruit.aid.domain.store.presentation.dto.response.StoreDetailResDto

interface StoreDetailService {
    fun execute(storeId: Long): StoreDetailResDto
}