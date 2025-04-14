package com.deal.serviceApp.repository

import com.akva.models.entity.ResponseStatusEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ResponseStatusRepository : JpaRepository<ResponseStatusEntity, String> {
    fun getByCode(code: String): ResponseStatusEntity?
}
