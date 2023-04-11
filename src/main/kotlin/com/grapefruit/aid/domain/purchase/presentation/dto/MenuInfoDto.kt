package com.grapefruit.aid.domain.purchase.presentation.dto

import com.grapefruit.aid.domain.menu.entity.Menu

data class MenuInfoDto(
    val menu: Menu,
    val quantity: Long
)