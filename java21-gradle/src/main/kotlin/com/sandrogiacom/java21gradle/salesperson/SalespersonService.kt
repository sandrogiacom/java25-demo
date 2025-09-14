package com.sandrogiacom.java21gradle.salesperson

import com.sandrogiacom.java21gradle.salesperson.dto.SalespersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

class NotFoundException(message: String) : RuntimeException(message)
class ConflictException(message: String) : RuntimeException(message)

@Service
class SalespersonService(
    private val repository: SalespersonRepository,
) {

    @Transactional
    fun create(req: SalespersonRequest): Salesperson {
        if (repository.existsByEmail(req.email)) {
            throw ConflictException("Email already in use: ${'$'}{req.email}")
        }
        val entity = Salesperson(
            email = req.email.trim(),
            firstName = req.firstName.trim(),
            lastName = req.lastName.trim(),
            dateOfBirth = req.dateOfBirth,
            active = req.active,
        )
        return repository.save(entity)
    }

    @Transactional(readOnly = true)
    fun get(id: Long): Salesperson =
        repository.findById(id).orElseThrow { NotFoundException("Salesperson not found: id=${'$'}id") }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<Salesperson> = repository.findAll(pageable)

    @Transactional
    fun update(id: Long, req: SalespersonRequest): Salesperson {
        val existing = get(id)
        if (existing.email != req.email && repository.existsByEmail(req.email)) {
            throw ConflictException("Email already in use: ${'$'}{req.email}")
        }
        existing.email = req.email.trim()
        existing.firstName = req.firstName.trim()
        existing.lastName = req.lastName.trim()
        existing.dateOfBirth = req.dateOfBirth
        existing.active = req.active
        return repository.save(existing)
    }

    @Transactional
    fun delete(id: Long) {
        val existing = get(id)
        repository.delete(existing)
    }
}
