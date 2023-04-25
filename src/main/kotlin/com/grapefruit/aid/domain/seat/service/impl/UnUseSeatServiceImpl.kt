package com.grapefruit.aid.domain.seat.service.impl

import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.seat.exception.SeatAlreadyUnUsedException
import com.grapefruit.aid.domain.seat.exception.SeatNotFoundException
import com.grapefruit.aid.domain.seat.repository.SeatRepository
import com.grapefruit.aid.domain.seat.service.UnUseSeatService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class UnUseSeatServiceImpl(
    private val seatRepository: SeatRepository
): UnUseSeatService {
    override fun execute(seatId: Long) {
        val seat: Seat = seatRepository.findByIdOrNull(seatId) ?: throw SeatNotFoundException()
        if(seat.enabled)
            throw SeatAlreadyUnUsedException()
        seatRepository.save(seat.updateEnableState())
    }
}