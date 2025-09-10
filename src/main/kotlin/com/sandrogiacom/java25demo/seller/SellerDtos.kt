package com.sandrogiacom.java25demo.seller

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.util.UUID


data class SellerRequest(
    @field:NotBlank(message = "Name is required")
    @field:Size(max = 120)
    val name: String,

    @field:NotBlank(message = "Email is required")
    @field:Email
    @field:Size(max = 160)
    val email: String,

    @field:Size(max = 30)
    val phone: String? = null,

    val active: Boolean = true,
)


data class SellerUpdateRequest(
    @field:NotBlank(message = "Name is required")
    @field:Size(max = 120)
    val name: String,

    @field:NotBlank(message = "Email is required")
    @field:Email
    @field:Size(max = 160)
    val email: String,

    @field:Size(max = 30)
    val phone: String? = null,

    val active: Boolean = true,
)


data class SellerResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val phone: String?,
    val active: Boolean,
    val createdAt: String?,
    val updatedAt: String?,
)


fun Seller.toResponse() = SellerResponse(
    id = this.id!!,
    name = this.name,
    email = this.email,
    phone = this.phone,
    active = this.active,
    createdAt = this.createdAt?.toString(),
    updatedAt = this.updatedAt?.toString(),
)
