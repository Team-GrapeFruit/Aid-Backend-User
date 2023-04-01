package com.grapefruit.aid.domain.store.service

import com.grapefruit.aid.domain.store.presentation.dto.request.StoreDetailReqDto

interface StoreDetailService {
    fun execute(storeId: Long): StoreDetailReqDto
}