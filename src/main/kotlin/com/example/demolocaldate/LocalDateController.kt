package com.example.demolocaldate

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/add-day")
class LocalDateController {

    @PostMapping
    fun addDay(
        @RequestBody date: LocalDateDto
    ) = LocalDateDto(
        date = date.date.plusDays(1)
    )
}
