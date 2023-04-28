package com.grapefruit.aid.domain.menu.service.impl

import com.grapefruit.aid.domain.menu.exception.MenuNotFoundException
import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuDetailResDto
import com.grapefruit.aid.domain.menu.repository.MenuRepository
import com.grapefruit.aid.domain.menu.service.GetMenuDetailService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetMenuDetailServiceImpl(
    private val menuRepository: MenuRepository
): GetMenuDetailService {
    override fun execute(menuId: Long): GetMenuDetailResDto {
        val menu = menuRepository.findByIdOrNull(menuId) ?: throw MenuNotFoundException()
        return GetMenuDetailResDto(menu)
    }
}