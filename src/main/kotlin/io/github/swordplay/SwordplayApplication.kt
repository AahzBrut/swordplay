package io.github.swordplay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class SwordplayApplication

fun main(args: Array<String>) {
    runApplication<SwordplayApplication>(*args)
}
