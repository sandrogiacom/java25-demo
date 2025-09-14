package com.sandrogiacom.java21gradle.salesperson.dto

import com.sandrogiacom.java21gradle.salesperson.Salesperson
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.Instant
import java.time.LocalDate

data class SalespersonRequest(
    @field:Email
    @field:NotBlank
    @field:Size(max = 255)
    val email: String,

    @field:NotBlank
    @field:Size(max = 100)
    val firstName: String,

    @field:NotBlank
    @field:Size(max = 100)
    val lastName: String,

    @field:NotNull
    @field:Past
    val dateOfBirth: LocalDate,

    val active: Boolean = true,
)

data class SalespersonResponse(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate,
    val active: Boolean,
    val createdAt: Instant?,
    val updatedAt: Instant?,
)

fun Salesperson.toResponse(): SalespersonResponse = SalespersonResponse(
    id = this.id!!,
    email = this.email,
    firstName = this.firstName,
    lastName = this.lastName,
    dateOfBirth = this.dateOfBirth,
    active = this.active,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
)
