package com.grapefruit.aid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AidBackendUserApplication

fun main(args: Array<String>) {
    runApplication<AidBackendUserApplication>(*args)
}
