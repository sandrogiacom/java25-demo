package com.sandrogiacom.java21gradle.salesperson

import com.sandrogiacom.java21gradle.salesperson.dto.SalespersonRequest
import com.sandrogiacom.java21gradle.salesperson.dto.SalespersonResponse
import com.sandrogiacom.java21gradle.salesperson.dto.toResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/salespeople")
@Tag(name = "Salespeople", description = "Operations related to salespeople management")
class SalespersonController(
    private val service: SalespersonService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a salesperson")
    fun create(@Validated @RequestBody req: SalespersonRequest): SalespersonResponse =
        service.create(req).toResponse()

    @GetMapping("/{id}")
    @Operation(summary = "Get a salesperson by id")
    fun get(@PathVariable id: Long): SalespersonResponse = service.get(id).toResponse()

    @GetMapping
    @Operation(summary = "List salespeople (paginated)")
    fun list(@ParameterObject pageable: Pageable): Page<SalespersonResponse> =
        service.list(pageable).map { it.toResponse() }

    @PutMapping("/{id}")
    @Operation(summary = "Update a salesperson")
    fun update(@PathVariable id: Long, @Validated @RequestBody req: SalespersonRequest): SalespersonResponse =
        service.update(id, req).toResponse()

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a salesperson")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
