package com.grapefruit.aid.domain.menu.entity

import com.grapefruit.aid.domain.category.entity.MenuAndCategory
import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
class Menu(
    @Column(name = "menu_name", nullable = false)
    @field:Size(max = 20)
    val menuName: String,
    @Column(name = "cost")
    val cost: Long,
    @Column(name = "description", nullable = false)
    @field:Size(max = 80)
    val description: String,
    @Column(name = "menu_img_url", nullable = true)
    val menuImgURL: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    val store: Store
):BaseIdEntity() {
    constructor(menu: Menu): this(
        menuName = menu.menuName,
        cost = menu.cost,
        description = menu.description,
        menuImgURL = menu.menuImgURL,
        store = menu.store
    )
}