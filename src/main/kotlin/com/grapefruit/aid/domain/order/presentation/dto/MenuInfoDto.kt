package com.grapefruit.aid.domain.order.presentation.dto

import com.grapefruit.aid.domain.menu.entity.Menu

data class MenuInfoDto(
    val menu: Menu,
    val quantity: Long
)