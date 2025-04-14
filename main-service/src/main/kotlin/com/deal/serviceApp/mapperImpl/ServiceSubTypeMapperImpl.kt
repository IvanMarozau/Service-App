package com.deal.serviceApp.mapperImpl

import com.akva.models.dto.ServiceSubTypeTO
import com.akva.models.dto.mapper.ServiceSubTypeMapper
import com.akva.models.entity.EnumServiceSubTypeEntity
import org.springframework.stereotype.Component

@Component
class ServiceSubTypeMapperImpl : ServiceSubTypeMapper {


    override fun toTO(serviceSubTypeEntity: EnumServiceSubTypeEntity): ServiceSubTypeTO {
        return ServiceSubTypeTO(serviceSubTypeEntity.id, serviceSubTypeEntity.name, serviceSubTypeEntity.serviceType.id)
    }

    override fun toTOList(serviceSubTypeEntities: List<EnumServiceSubTypeEntity>): List<ServiceSubTypeTO> {
        return serviceSubTypeEntities.map { toTO(it) }
    }

}