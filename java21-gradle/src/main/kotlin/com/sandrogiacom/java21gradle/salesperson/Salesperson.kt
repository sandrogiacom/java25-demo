package com.sandrogiacom.java21gradle.salesperson

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(
    name = "salespeople",
    uniqueConstraints = [UniqueConstraint(columnNames = ["email"])],
    indexes = [Index(name = "idx_salespeople_email", columnList = "email")]
)
class Salesperson(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:Email
    @field:NotBlank
    @field:Size(max = 255)
    @Column(nullable = false, unique = true)
    var email: String,

    @field:NotBlank
    @field:Size(max = 100)
    @Column(nullable = false)
    var firstName: String,

    @field:NotBlank
    @field:Size(max = 100)
    @Column(nullable = false)
    var lastName: String,

    @field:Past
    @Column(nullable = false)
    var dateOfBirth: LocalDate,

    @Column(nullable = false)
    var active: Boolean = true,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    var createdAt: Instant? = null,

    @UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: Instant? = null,
)
