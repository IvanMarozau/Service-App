package com.deal.serviceApp.mapperImpl

import com.akva.models.dto.ServiceTypeTO
import com.akva.models.dto.mapper.ServiceTypeMapper
import com.akva.models.entity.EnumServiceTypeEntity
import org.springframework.stereotype.Component

@Component
class ServiceTypeMapperImpl : ServiceTypeMapper {
    override fun toEntity(serviceTypeTO: ServiceTypeTO): EnumServiceTypeEntity {
        return EnumServiceTypeEntity(
            id = serviceTypeTO.id,
            name = serviceTypeTO.name
        )
    }

    override fun toTO(serviceTypeEntity: EnumServiceTypeEntity): ServiceTypeTO {
        return ServiceTypeTO(
            id = serviceTypeEntity.id,
            name = serviceTypeEntity.name
        )
    }

    override fun toEntityList(serviceTypeTOs: List<ServiceTypeTO>): List<EnumServiceTypeEntity> {
        return serviceTypeTOs.map { toEntity(it) }
    }

    override fun toTOList(serviceTypeEntities: List<EnumServiceTypeEntity>): List<ServiceTypeTO> {
        return serviceTypeEntities.map { toTO(it) }
    }

}