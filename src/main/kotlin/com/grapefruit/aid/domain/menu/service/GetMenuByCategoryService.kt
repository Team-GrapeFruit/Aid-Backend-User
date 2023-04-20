package com.grapefruit.aid.domain.menu.service

interface GetMenuByCategoryService {
    fun execute(storeId: Long, categoryId: Long)
}