package com.grapefruit.aid.domain.menu.repository

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.domain.store.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository: JpaRepository<Menu, Long> {
    fun findAllByStore(store: Store): List<Menu>
}