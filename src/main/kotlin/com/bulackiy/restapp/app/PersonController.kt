package com.bulackiy.restapp.app

import com.bulackiy.restapp.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("person")
class PersonController(private val personService: PersonService) {

    @GetMapping
    fun index() = personService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody person: Person) = personService.add(person)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = personService.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody person: Person) =
            personService.edit(person, id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = personService.remove(id)

    @PutMapping("{id}/phone")
    fun addPhone(@PathVariable id: Long, @RequestBody phone: Phone) {
        val personResponse = personService.get(id)
        val person: Person
        if(personResponse.isPresent) {
            person = personResponse.get()
            person.additionalPhones.add(phone)
            personService.edit(person, id)
        }
    }

    @PutMapping("{id}/address")
    fun addAddress(@PathVariable id: Long, @RequestBody address: Address) {
        val personResponse = personService.get(id)
        val person: Person
        if(personResponse.isPresent) {
            person = personResponse.get()
            person.additionalAddresses.add(address)
            personService.edit(person, id)
        }
    }
}