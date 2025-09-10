package com.sandrogiacom.java25demo.seller

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

class NotFoundException(message: String) : RuntimeException(message)

@Service
class SellerService(
    private val repository: SellerRepository,
) {

    @Transactional
    fun create(request: SellerRequest): SellerResponse {
        if (repository.existsByEmail(request.email)) {
            throw DataIntegrityViolationException("Email already registered")
        }
        val seller = Seller(
            name = request.name,
            email = request.email,
            phone = request.phone,
            active = request.active,
        )
        val saved = repository.save(seller)
        return saved.toResponse()
    }

    @Transactional(readOnly = true)
    fun findById(id: UUID): SellerResponse =
        repository.findById(id).orElseThrow { NotFoundException("Seller not found") }.toResponse()

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<SellerResponse> =
        repository.findAll(pageable).map { it.toResponse() }

    @Transactional
    fun update(id: UUID, request: SellerUpdateRequest): SellerResponse {
        val existing = repository.findById(id).orElseThrow { NotFoundException("Seller not found") }
        // If email changed, check for duplicates
        if (existing.email != request.email && repository.existsByEmail(request.email)) {
            throw DataIntegrityViolationException("Email already registered")
        }
        existing.name = request.name
        existing.email = request.email
        existing.phone = request.phone
        existing.active = request.active
        return repository.save(existing).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repository.existsById(id)) {
            throw NotFoundException("Seller not found")
        }
        repository.deleteById(id)
    }
}
