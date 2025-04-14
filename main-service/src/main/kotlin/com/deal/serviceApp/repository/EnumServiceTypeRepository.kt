package com.deal.serviceApp.repository

import com.akva.models.entity.EnumServiceTypeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EnumServiceTypeRepository : JpaRepository<EnumServiceTypeEntity, Long> {
}
