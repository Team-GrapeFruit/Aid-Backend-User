package com.grapefruit.aid.domain.store.service.impl

import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.presentation.dto.request.StoreDetailReqDto
import com.grapefruit.aid.domain.store.repository.StoreRepository
import com.grapefruit.aid.domain.store.service.StoreDetailService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class StoreDetailServiceImpl(
    private val seatRepository: SeatRepository,
    private val storeRepository: StoreRepository
): StoreDetailService {
    override fun execute(storeId: Long): StoreDetailReqDto {
        val store: Store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        val seatList : List<StoreDetailReqDto.SingleSeatDto> = seatRepository.findAllByStore(store)
            .map { seat -> StoreDetailReqDto.SingleSeatDto(seat)}

        return StoreDetailReqDto(store, seatList)
    }
}