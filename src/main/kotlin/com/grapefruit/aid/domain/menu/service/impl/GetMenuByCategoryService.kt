package com.grapefruit.aid.domain.menu.service.impl

import com.grapefruit.aid.domain.category.exception.CategoryNotFoundException
import com.grapefruit.aid.domain.category.repository.CategoryRepository
import com.grapefruit.aid.domain.category.repository.MenuCategoryRepository
import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.menu.presentation.dto.response.GetMenuByCategoryResDto
import com.grapefruit.aid.domain.menu.service.GetMenuByCategoryService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class GetMenuByCategoryService(
    private val categoryRepository: CategoryRepository,
    private val menuCategoryRepository: MenuCategoryRepository
): GetMenuByCategoryService {
    override fun execute(categoryId: Long): List<GetMenuByCategoryResDto> {
        val category = categoryRepository.findByIdOrNull(categoryId) ?: throw CategoryNotFoundException()
        return menuCategoryRepository.findAllByCategory(category)
            .map { GetMenuByCategoryResDto(it.menu) }
    }

}