package com.deal.serviceApp.service

import com.akva.models.dto.ServiceTypeTO
import com.akva.models.dto.mapper.ServiceTypeMapper
import com.deal.serviceApp.repository.EnumServiceTypeRepository
import org.springframework.stereotype.Service

@Service
class ServiceTypeService(
    val serviceTypeMapper: ServiceTypeMapper, val serviceTypeRepository: EnumServiceTypeRepository
) {

    fun getAllServiceTypes(): List<ServiceTypeTO> {
        return serviceTypeMapper.toTOList(serviceTypeRepository.findAll().toList())
    }
}