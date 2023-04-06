package com.grapefruit.aid.domain.seat.service

import com.grapefruit.aid.domain.seat.presentation.dto.response.SingleSeatResponse

interface SeatListService {
    fun execute(storeId: Long): List<SingleSeatResponse>
}