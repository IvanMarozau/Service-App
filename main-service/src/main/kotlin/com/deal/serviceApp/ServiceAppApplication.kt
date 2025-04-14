package com.deal.serviceApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.akva.models", "com.deal.serviceApp"])
@EntityScan(basePackages = ["com.akva.models.entity"])
class ServiceAppApplication

fun main(args: Array<String>) {
	runApplication<ServiceAppApplication>(*args)
}
