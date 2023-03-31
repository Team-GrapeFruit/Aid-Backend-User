package com.grapefruit.aid.domain.seat.entity

import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.*

@Entity
class Seat (
    @Column(name = "seat_num", nullable = false)
    val seatNum: Long,
    @Column(name = "customer_num", nullable = false)
    val customerNum: Long,
    @Column(nullable = false)
    val enabled: Boolean,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Column(name = "store_id", nullable = false)
    val store: Store
): BaseIdEntity()