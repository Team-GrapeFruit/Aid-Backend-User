package com.grapefruit.aid.domain.seat.presentation

import com.grapefruit.aid.domain.seat.presentation.dto.response.SingleSeatResponse
import com.grapefruit.aid.domain.seat.service.SeatListService
import com.grapefruit.aid.domain.seat.service.UnUseSeatService
import com.grapefruit.aid.domain.seat.service.UseSeatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seat")
class SeatController(
    private val userSeatService: UseSeatService,
    private val unUseSeatService: UnUseSeatService,
    private val seatListService: SeatListService
) {
    @PatchMapping("/allow/{seat_id}")
    fun useSeat(@PathVariable("seat_id") seatId: Long): ResponseEntity<Void> {
        userSeatService.execute(seatId)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping("/cancel/{seat_id}")
    fun unUseSeat(@PathVariable("seat_id") seatId: Long): ResponseEntity<Void> {
        unUseSeatService.execute(seatId)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{store_id}")
    fun getSeatList(@PathVariable("store_id") storeId: Long):ResponseEntity<List<SingleSeatResponse>> {
        val result: List<SingleSeatResponse> = seatListService.execute(storeId)
        return ResponseEntity.ok(result)
    }
}