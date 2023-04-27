package com.grapefruit.aid.domain.seat.presentation.dto.response

import com.grapefruit.aid.domain.seat.entity.Seat

data class SeatListResponse(
    val singleSeatResponse: List<SingleSeatResponse>
) {
    data class SingleSeatResponse(
        val seatId: Long,
        val seatNum: Long,
        val customerNum: Long,
        val enabled: Boolean,
        val locationX: Float,
        val locationY: Float
    ) {
        constructor(seat: Seat) : this(
            seatId = seat.id,
            seatNum = seat.seatNum,
            customerNum = seat.customerNum,
            enabled = seat.enabled,
            locationX = seat.locationX,
            locationY = seat.locationY
        )
    }
}