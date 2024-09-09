package com.example.demolocaldate

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/add-day")
class LocalDateController(
    private val springObjectMapper: ObjectMapper
) {
    private val myObjectMapper = ObjectMapper()

    @PostMapping
    fun addDay(
        @RequestBody date: LocalDateDto
    ) = LocalDateDto(
        date = date.date.plusDays(1)
    )

    @PostMapping(
        "/working",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addDaySpringObjectMapper(
        @RequestBody body: String
    ): String {
        val input: LocalDateDto = springObjectMapper.readValue(body)
        return springObjectMapper.writeValueAsString(
            LocalDateDto(
                date = input.date.plusDays(1)
            )
        )
    }

    @PostMapping(
        "/not-working",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addDayCreatedObjectMapper(
        @RequestBody body: String
    ): String {
        val input: LocalDateDto = myObjectMapper.readValue(body)
        return myObjectMapper.writeValueAsString(
            LocalDateDto(
                date = input.date.plusDays(1)
            )
        )
    }

}
