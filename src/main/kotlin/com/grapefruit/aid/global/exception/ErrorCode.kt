package com.grapefruit.aid.global.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    STORE_NOT_FOUND("가게를 찾을 수 없습니다", 404)
}