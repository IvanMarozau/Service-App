package com.deal.serviceApp.service

import com.akva.models.dto.UserCreationRequest
import com.akva.models.entity.UserEntity
import com.akva.models.entity.UserType
import com.deal.serviceApp.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Service
class UserService(
    private val userRepo: UserRepository,
) {
    fun create(request: UserCreationRequest) {
        val user = UserEntity(
            request.id,
            request.name,
            request.email,
            request.role,
            0,
            0,
            Date.from(LocalDate.now().plusMonths(3).atStartOfDay(ZoneId.systemDefault()).toInstant()),
            300,
        )
        userRepo.save(user)
    }
}