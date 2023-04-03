package com.grapefruit.aid.domain.store.entity

import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.validation.constraints.Size


@Entity
class Store (
    @Column(name = "store_name", nullable = false)
    @field:Size(max = 20)
    val storeName: String,
    @Column(nullable = false)
    @field:Size(max = 80)
    val information: String,
    @Column(name = "store_img_url", nullable = true)
    val storeImgURL: String? = null
): BaseIdEntity()