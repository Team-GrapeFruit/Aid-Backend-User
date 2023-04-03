package com.grapefruit.aid.domain.menu.entity

import com.grapefruit.aid.domain.store.entity.Store
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.*

@Entity
class Menu(
    @Column(name = "menu_name", nullable = false)
    val menuName: String,
    @Column(name = "description", nullable = false)
    val description: String,
    @Column(name = "menu_img_url", nullable = true)
    val menuImgURL: String? = null,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @Column(name = "store_id", nullable = false)
    val store: Store
):BaseIdEntity()