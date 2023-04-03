package com.grapefruit.aid.domain.order.repository

import com.grapefruit.aid.domain.order.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long>{
}