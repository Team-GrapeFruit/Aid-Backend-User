package com.grapefruit.aid.domain.store.presentation.dto.response

import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.store.entity.Store

data class StoreDetailResDto(
    val storeId: Long,
    val storeName: String,
    val information: String,
    val storeImgURL: String?,
    val seatDto: List<SingleSeatDto>
) {
    data class SingleSeatDto(
        val seatId: Long,
        val seatNum: Long,
        val customerNum: Long,
        val enabled: Boolean
    ) {
        constructor(seat: Seat): this(
            seatId = seat.id,
            seatNum = seat.seatNum,
            customerNum = seat.customerNum,
            enabled = seat.enabled
        )
    }

    constructor(store: Store, seatDto: List<SingleSeatDto>): this(
        storeId = store.id,
        storeName = store.storeName,
        information = store.information,
        storeImgURL = store.storeImgURL,
        seatDto = seatDto
    )
}