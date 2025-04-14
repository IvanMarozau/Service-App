package com.deal.serviceApp.repository

import com.akva.models.entity.EnumServiceSubTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EnumServiceSubTypeRepository : JpaRepository<EnumServiceSubTypeEntity, Long> {
    fun getByName(name: String): EnumServiceSubTypeEntity?
}
