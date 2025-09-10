package com.sandrogiacom.java25demo.seller

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SellerRepository : JpaRepository<Seller, UUID> {
    fun existsByEmail(email: String): Boolean
}
