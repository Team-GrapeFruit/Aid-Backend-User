package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.purchase.exception.PurchaseNotFoundException
import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.DeleteMenuFromPurchaseService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class DeleteMenuFromPurchaseServiceImpl(
    private val purchaseRepository: PurchaseRepository
): DeleteMenuFromPurchaseService {
    override fun execute(purchaseId: Long) {
        val purchase = purchaseRepository.findByIdOrNull(purchaseId) ?: throw PurchaseNotFoundException()
        purchaseRepository.delete(purchase)
    }
}