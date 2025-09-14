package com.sandrogiacom.java25demo.seller

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/api/v1/sellers")
@OpenAPIDefinition(
    info = io.swagger.v3.oas.annotations.info.Info(
        title = "Seller API",
        version = "1.0",
        description = "API for managing sellers"
    ))
class SellerController(
    private val service: SellerService,
) {
    @PostMapping
    fun create(@Valid @RequestBody request: SellerRequest): ResponseEntity<SellerResponse> {
        val created = service.create(request)
        return ResponseEntity.created(URI.create("/api/v1/sellers/${'$'}{created.id}")).body(created)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): SellerResponse = service.findById(id)

    @GetMapping
    fun list(pageable: Pageable): Page<SellerResponse> = service.list(pageable)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @Valid @RequestBody request: SellerUpdateRequest): SellerResponse =
        service.update(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) = service.delete(id)
}
