package com.grapefruit.aid.domain.order.entity

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.order.presentation.dto.MenuInfoDto
import com.grapefruit.aid.domain.order.presentation.dto.request.CreateOrderReqDto
import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.*

@Entity
class Order(
    @Column(name = "quantity", nullable = false)
    val quantity: Long,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Column(name = "seat_id", nullable = false)
    val seat: Seat,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Column(name = "menu_id", nullable = false)
    val menu: Menu,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Column(name = "store_id", nullable = true)
    val store: Store
): BaseIdEntity() {
    constructor(store: Store, seat: Seat, menuInfoDto: MenuInfoDto): this(
        store = store,
        seat = seat,
        menu = menuInfoDto.menu,
        quantity = menuInfoDto.quantity
    )
}