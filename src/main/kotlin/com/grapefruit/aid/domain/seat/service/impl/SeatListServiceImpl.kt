package com.grapefruit.aid.domain.seat.service.impl

import com.grapefruit.aid.domain.seat.presentation.dto.response.SeatListResponse
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.seat.service.SeatListService
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.repository.StoreRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SeatListServiceImpl(
    private val seatRepository: SeatRepository,
    private val storeRepository: StoreRepository
): SeatListService {
    override fun execute(storeId: Long): SeatListResponse {
        val store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        val seatListDto = seatRepository.findAllByStore(store)
                            .map { SeatListResponse.SingleSeatResponse(it) }
        return SeatListResponse(seatListDto)
    }
}