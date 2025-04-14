package com.deal.serviceApp.repository

import com.akva.models.entity.PackageEntity
import org.springframework.data.jpa.repository.JpaRepository


interface PackageRepository : JpaRepository<PackageEntity, Long> {

}

