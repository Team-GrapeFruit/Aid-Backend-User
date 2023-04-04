package com.grapefruit.aid.domain.seat.exception

import com.grapefruit.aid.global.exception.ErrorCode
import com.grapefruit.aid.global.exception.exceptions.BasicException

class SeatAlreadyUnUsedException: BasicException(ErrorCode.SEAT_ALREADY_UNUSED) {
}