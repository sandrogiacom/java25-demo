package com.sandrogiacom.java21gradle

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class OpenApiDocsTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `v3 api docs should return 200`() {
        mockMvc.get("/v3/api-docs")
            .andExpect { status { isOk() } }
    }
}
