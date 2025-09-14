package com.sandrogiacom.java21gradle.salesperson

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SalespersonRepository : JpaRepository<Salesperson, Long> {
    fun existsByEmail(email: String): Boolean
}
