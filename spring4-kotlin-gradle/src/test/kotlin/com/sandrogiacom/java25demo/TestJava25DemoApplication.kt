package com.sandrogiacom.java25demo

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<Java25DemoApplication>().with(TestcontainersConfiguration::class).run(*args)
}
