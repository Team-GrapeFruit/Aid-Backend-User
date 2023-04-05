package com.grapefruit.aid.domain.order.presentation.dto.request

import javax.validation.constraints.NotNull

data class CreateOrderReqDto(
    @field:NotNull
    val quantity: Long
)