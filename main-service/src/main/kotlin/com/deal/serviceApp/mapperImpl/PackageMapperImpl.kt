package com.deal.serviceApp.mapperImpl

import com.akva.models.dto.PackageTO
import com.akva.models.dto.mapper.PackageMapper
import com.akva.models.entity.PackageEntity
import org.springframework.stereotype.Component

@Component
class PackageMapperImpl: PackageMapper {
    override fun toEntity(packageTO: PackageTO): PackageEntity {
        return PackageEntity(
            type = packageTO.type,
            price = packageTO.price,
            value = packageTO.value,
            active_per = packageTO.activePer
        )
    }
    override fun toTo(packageEntity: PackageEntity): PackageTO {
        return PackageTO(
            type = packageEntity.type,
            price = packageEntity.price,
            value = packageEntity.value,
            activePer = packageEntity.active_per
        )
    }
    override fun toEntityList(packageTOs: List<PackageTO>): List<PackageEntity> {
        return packageTOs.map { toEntity(it) }
    }
    override fun toTOList(packageEntities: List<PackageEntity>): List<PackageTO> {
        return packageEntities.map { toTo(it) }
    }




}