package com.grapefruit.aid.domain.seat.presentation

import com.grapefruit.aid.domain.seat.service.UseSeatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seat")
class SeatController(
    private val userSeatService: UseSeatService
) {
    @PatchMapping("/allow/{seat_id}")
    fun useSeat(@PathVariable("seat_id") seatId: Long): ResponseEntity<Void> {
        userSeatService.execute(seatId)
        return ResponseEntity.noContent().build()
    }
}