package com.grapefruit.aid.domain.seat.service

import com.grapefruit.aid.domain.seat.presentation.dto.response.SeatListResponse

interface SeatListService {
    fun execute(storeId: Long): SeatListResponse
}