package com.grapefruit.aid.domain.seat.service.impl

import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.seat.exception.SeatAlreadyUsedException
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.seat.service.UseSeatService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
@Transactional(rollbackFor = [Exception::class])
class UseSeatServiceImpl(
    private val seatRepository: SeatRepository
): UseSeatService {
    override fun execute(seatId: Long) {
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        if(!seat.enabled)
            throw SeatAlreadyUsedException()
        seatRepository.save(seat.updateEnableState())
    }
}