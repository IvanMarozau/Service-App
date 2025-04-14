package com.deal.serviceApp.mapperImpl

import com.akva.models.dto.UserTO
import com.akva.models.dto.mapper.UserMapper
import com.akva.models.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapperImpl : UserMapper {

    override fun toTO(userEntity: UserEntity): UserTO {
        return UserTO(
            id = userEntity.id.toString(),
            name = userEntity.name,
            email = userEntity.email,
            role = userEntity.role,
            totalScore = userEntity.totalScore,
            revCount = userEntity.revCount,
            balance = userEntity.balance.toFloat(),
            expireDate = userEntity.expireDate
        )
    }

}