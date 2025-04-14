package com.deal.serviceApp.mapperImpl

import com.akva.models.dto.TicketTO
import com.akva.models.dto.mapper.TicketMapper
import com.akva.models.entity.TicketEntity
import com.deal.serviceApp.repository.EnumServiceSubTypeRepository
import com.deal.serviceApp.repository.TicketStatusRepository
import com.deal.serviceApp.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class TicketMapperImpl(
    private val serviceSubTypeRepo: EnumServiceSubTypeRepository,
    private val userRepository: UserRepository,
    private val ticketStatusRepo: TicketStatusRepository,
    private val userMapper: UserMapperImpl
) : TicketMapper {


    override fun toEntity(ticketTO: TicketTO): TicketEntity? {
        val statusValue = ticketStatusRepo.getByCode(ticketTO.ticketStatus) ?: return null
        val authorValue = userRepository.findById(UUID.fromString(ticketTO.author.id))
        val taskerValue = userRepository.findById(UUID.fromString(ticketTO.tasker.id))
        val serviceSubTypeValue = serviceSubTypeRepo.getByName(ticketTO.subType) ?: return null
        if (authorValue.isEmpty || taskerValue.isEmpty) {
            return null
        }
        return TicketEntity(
            description = ticketTO.description,
            location = ticketTO.location,
            finishTimestamp = ticketTO.finishDate,
            creationTimestamp = LocalDate.now(),
            status = statusValue,
            author = authorValue.get(),
            serviceSubType = serviceSubTypeValue,
            budget = ticketTO.budget,
            lastNotificationDateTime = null,
            tasker = taskerValue.get()
        )
    }

    override fun toTO(ticketEntity: TicketEntity): TicketTO {
        return TicketTO(
            subType = ticketEntity.serviceSubType.name,
            description = ticketEntity.description,
            budget = ticketEntity.budget,
            location = ticketEntity.location,
            creationDate = ticketEntity.creationTimestamp,
            finishDate = ticketEntity.finishTimestamp,
            author = userMapper.toTO(ticketEntity.author),
            ticketStatus = ticketEntity.status.code,
            tasker= userMapper.toTO(ticketEntity.tasker)
        )
    }


    override fun toTOList(ticketEntities: List<TicketEntity>): List<TicketTO> {
        return ticketEntities.map { toTO(it) }
    }


}