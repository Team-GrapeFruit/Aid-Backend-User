package com.grapefruit.aid.domain.store.service.impl

import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.presentation.dto.response.StoreDetailResDto
import com.grapefruit.aid.domain.store.repository.StoreRepository
import com.grapefruit.aid.domain.store.service.StoreDetailService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class StoreDetailServiceImpl(
    private val storeRepository: StoreRepository
): StoreDetailService {
    override fun execute(storeId: Long): StoreDetailResDto {
        val store: Store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        return StoreDetailResDto(store)
    }
}