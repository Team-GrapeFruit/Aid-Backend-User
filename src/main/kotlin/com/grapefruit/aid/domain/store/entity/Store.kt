package com.grapefruit.aid.domain.store.entity

import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity


@Entity
class Store (
    @Column(name = "store_name", nullable = false)
    val storeName: String,
    @Column(nullable = false)
    val information: String,
    @Column(name = "store_img_url", nullable = true)
    val storeImgURL: String? = null
): BaseIdEntity()