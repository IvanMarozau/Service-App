package com.deal.serviceApp.controller

import com.akva.models.dto.AppInfoTO
import com.deal.serviceApp.service.PackageService
import com.deal.serviceApp.service.ServiceSubTypeService
import com.deal.serviceApp.service.ServiceTypeService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/appInfo")
class BaseController(
    private val serviceTypeService: ServiceTypeService,
    private val serviceSubTypeService: ServiceSubTypeService,
    private val packageService: PackageService
) {

    @GetMapping("/base")
    fun initial(): AppInfoTO {
        return AppInfoTO(serviceTypeService.getAllServiceTypes(), serviceSubTypeService.getAllServiceSubTypes(), packageService.getAllPackages())
    }
}
