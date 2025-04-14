package com.deal.serviceApp.repository

import com.akva.models.entity.TicketEntity
import com.akva.models.entity.TicketStatusEntity
import com.deal.serviceApp.service.TicketSpecification
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*


interface TicketRepository : JpaRepository<TicketEntity, UUID>, JpaSpecificationExecutor<TicketEntity>{

    override fun findById(id: UUID): Optional<TicketEntity>

    fun findAllByStatus(ticketStatusEntity: TicketStatusEntity): List<TicketEntity>?

    fun findAllByAuthorId(id: UUID): Optional<List<TicketEntity>>

    @Modifying
    @Transactional
    @Query("UPDATE TicketEntity t SET t.lastNotificationDateTime = :lastNotificationDate WHERE t.id = :id")
    fun updateLastNotificationDate(id: UUID, lastNotificationDate: LocalDateTime): Int
}