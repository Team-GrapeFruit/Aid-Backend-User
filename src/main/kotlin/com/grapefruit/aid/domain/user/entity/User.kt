package com.grapefruit.aid.domain.user.entity

import com.grapefruit.aid.global.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User(
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val name: String
): BaseIdEntity()