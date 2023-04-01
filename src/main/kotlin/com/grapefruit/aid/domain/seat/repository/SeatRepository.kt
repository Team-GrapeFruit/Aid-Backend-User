package com.grapefruit.aid.domain.seat.repository

import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.store.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository: JpaRepository<Seat, Long> {
    fun findAllByStore(store: Store): List<Seat>
}