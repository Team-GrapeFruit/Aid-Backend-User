package com.grapefruit.aid.domain.purchase.service.impl

import com.grapefruit.aid.domain.purchase.exception.PurchaseNotFoundException
import com.grapefruit.aid.domain.purchase.presentation.dto.request.ModifyPurchaseQuantityReqDto
import com.grapefruit.aid.domain.purchase.repository.PurchaseRepository
import com.grapefruit.aid.domain.purchase.service.ModifyPurchaseQuantityService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class ModifyPurchaseQuantityServiceImpl(
    private val purchaseRepository: PurchaseRepository
): ModifyPurchaseQuantityService {
    override fun execute(purchaseId: Long, modifyPurchaseQuantityReqDto: ModifyPurchaseQuantityReqDto) {
        val purchase = purchaseRepository.findByIdOrNull(purchaseId) ?: throw PurchaseNotFoundException()
        purchaseRepository.save(purchase.update(modifyPurchaseQuantityReqDto))
    }
}