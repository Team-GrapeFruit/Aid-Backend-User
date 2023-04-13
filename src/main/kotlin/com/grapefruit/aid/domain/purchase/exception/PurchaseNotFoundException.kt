package com.grapefruit.aid.domain.purchase.exception

import com.grapefruit.aid.global.exception.ErrorCode
import com.grapefruit.aid.global.exception.exceptions.BasicException

class PurchaseNotFoundException: BasicException(ErrorCode.PURCHASE_NOT_FOUND) {
}