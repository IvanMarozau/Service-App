package com.deal.serviceApp.repository

import com.akva.models.entity.QualificationEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface QualificationRepository : JpaRepository<QualificationEntity, UUID>
