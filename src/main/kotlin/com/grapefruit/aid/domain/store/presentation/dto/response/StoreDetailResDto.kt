package com.grapefruit.aid.domain.store.presentation.dto.response

import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.store.entity.Store

data class StoreDetailResDto(
    val storeId: Long,
    val storeName: String,
    val information: String,
    val storeImgURL: String?,
) {


    constructor(store: Store): this(
        storeId = store.id,
        storeName = store.storeName,
        information = store.information,
        storeImgURL = store.storeImgURL,
    )
}