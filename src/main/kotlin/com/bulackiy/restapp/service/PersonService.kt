package com.bulackiy.restapp.service

import com.bulackiy.restapp.app.Person
import com.bulackiy.restapp.app.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(private val personRepository: PersonRepository) {

    fun all(): Iterable<Person> = personRepository.findAll()

    fun get(id: Long): Optional<Person> = personRepository.findById(id)

    fun add(person: Person): Person = personRepository.save(person)

    fun edit(person: Person, id: Long): Person = personRepository
            .save(person.copy(id = id))

    fun remove(id: Long) = personRepository.deleteById(id)
}