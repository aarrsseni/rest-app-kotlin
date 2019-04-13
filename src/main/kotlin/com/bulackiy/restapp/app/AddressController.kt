package com.bulackiy.restapp.app

import com.bulackiy.restapp.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("address")
class AddressController(private val addressService: AddressService) {

    @GetMapping
    fun index() = addressService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody address: Address) = addressService.add(address)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = addressService.get(id)
}