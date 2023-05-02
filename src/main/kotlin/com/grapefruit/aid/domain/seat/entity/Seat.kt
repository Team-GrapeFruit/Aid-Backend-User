package com.grapefruit.aid.domain.seat.entity

import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.user.entity.User
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
    @Column(name = "location_x", nullable = false)
    val locationX: Float,
    @Column(name = "location_y", nullable = false)
    val locationY: Float,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    val store: Store
): BaseIdEntity() {
    fun updateEnableState(): Seat {
        val updatedSeat = Seat(
            seatNum = this.seatNum,
            customerNum = this.customerNum,
            enabled = true,
            locationX = this.locationX,
            locationY = this.locationY,
            store = this.store
        )
        updatedSeat.id = this.id
        return updatedSeat
    }

    fun updateDisableState(): Seat {
        val updatedSeat = Seat(
            seatNum = this.seatNum,
            customerNum = this.customerNum,
            enabled = false,
            locationX = this.locationX,
            locationY = this.locationY,
            store = this.store
        )
        updatedSeat.id = this.id
        return updatedSeat
    }
}