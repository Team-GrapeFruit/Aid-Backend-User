package com.grapefruit.aid.domain.store.entity

import com.grapefruit.aid.domain.user.entity.User
import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.*
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
    val storeImgURL: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User
): BaseIdEntity()