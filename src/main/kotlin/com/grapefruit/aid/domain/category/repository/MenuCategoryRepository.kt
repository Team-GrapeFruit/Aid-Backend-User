package com.grapefruit.aid.domain.category.repository

import com.grapefruit.aid.domain.category.entity.Category
import com.grapefruit.aid.domain.category.entity.MenuAndCategory
import org.springframework.data.jpa.repository.JpaRepository

interface MenuCategoryRepository: JpaRepository<MenuAndCategory, Long> {
    fun findAllByCategory(category: Category): List<MenuAndCategory>
}