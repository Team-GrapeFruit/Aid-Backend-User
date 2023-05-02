package com.grapefruit.aid.domain.category.entity

import com.grapefruit.aid.domain.menu.entity.Menu
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class MenuAndCategory(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    val menu: Menu,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category
): BaseIdEntity()