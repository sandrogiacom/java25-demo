package com.sandrogiacom.java21gradle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class Java21GradleApplication

fun main(args: Array<String>) {
    runApplication<Java21GradleApplication>(*args)
}
