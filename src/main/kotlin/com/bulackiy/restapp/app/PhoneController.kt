package com.bulackiy.restapp.app

import com.bulackiy.restapp.service.PhoneService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("phone")
class PhoneController(private val phoneService: PhoneService) {

    @GetMapping
    fun index() = phoneService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody phone: Phone) = phoneService.add(phone)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = phoneService.get(id)
}