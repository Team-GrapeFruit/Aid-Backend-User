package com.grapefruit.aid.domain.menu.service.impl

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.menu.presentation.dto.response.SingleMenuListResDto
import com.grapefruit.aid.domain.menu.repository.MenuRepository
import com.grapefruit.aid.domain.menu.service.MenuListService
import com.grapefruit.aid.domain.seat.entity.Seat
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.domain.store.exception.StoreNotFoundException
import com.grapefruit.aid.domain.store.repository.StoreRepository
import org.springframework.data.repository.findByIdOrNull

class MenuListServiceImpl(
    private val storeRepository: StoreRepository,
    private val menuRepository: MenuRepository
): MenuListService {
    override fun execute(storeId: Long): List<SingleMenuListResDto>
        = getAllMenu(storeId)
            .map { SingleMenuListResDto(it) }

    private fun getAllMenu(storeId: Long): List<Menu> {
        val store: Store = storeRepository.findByIdOrNull(storeId) ?: throw StoreNotFoundException()
        return menuRepository.findAllByStore(store)
    }
}