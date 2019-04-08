package com.bulackiy.restapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestAppApplication

fun main(args: Array<String>) {
	runApplication<RestAppApplication>(*args)
}
