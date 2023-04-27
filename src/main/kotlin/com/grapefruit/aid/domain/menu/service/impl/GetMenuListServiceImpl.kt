package com.grapefruit.aid.domain.menu.service.impl

import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuListResDto
import com.grapefruit.aid.domain.menu.repository.MenuRepository
import com.grapefruit.aid.domain.menu.service.GetMenuListService
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.repository.StoreRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class GetMenuListServiceImpl(
    private val storeRepository: StoreRepository,
    private val menuRepository: MenuRepository
): GetMenuListService {
    override fun execute(storeId: Long): GetMenuListResDto {
        val store: Store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        return GetMenuListResDto(menuRepository.findAllByStore(store)
            .map { GetMenuListResDto.SingleGetMenuResDto(it) })
    }
}