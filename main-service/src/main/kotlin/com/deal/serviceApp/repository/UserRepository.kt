package com.deal.serviceApp.repository

import com.akva.models.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*


interface UserRepository : JpaRepository<UserEntity, UUID> {

    fun findByEmail(email: String): UserEntity?


    @Query("SELECT u.expire_date FROM InternalUser u WHERE u.id = :id", nativeQuery = true)
    fun getExpireDateByUserId(@Param("id") id: UUID): LocalDate

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE InternalUser SET balance = balance + :value WHERE id = :id
""", nativeQuery = true)
    fun updateBalance(@Param("id") id: UUID, @Param("value") balance: Float): Int

    @Modifying
    @Transactional
    @Query(
        value = "UPDATE InternalUser SET expire_date = CAST(:interval AS INTERVAL) WHERE id = :id",
        nativeQuery = true
    )
    fun updateExpiredDate(@Param("id") id: UUID, @Param("interval") interval: String)


    @Modifying
    @Transactional
    @Query(
        value = "UPDATE InternalUser SET expire_date = expire_date + CAST(:interval AS INTERVAL) WHERE id = :id",
        nativeQuery = true)
    fun updateExpireDate(@Param("id") id: UUID, @Param("interval") interval: String)

    }
