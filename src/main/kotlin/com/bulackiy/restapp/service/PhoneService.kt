package com.bulackiy.restapp.service

import com.bulackiy.restapp.app.Phone
import com.bulackiy.restapp.app.PhoneRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhoneService(private val phoneRepository: PhoneRepository) {

    fun all(): Iterable<Phone> = phoneRepository.findAll()

    fun get(id: Long): Optional<Phone> = phoneRepository.findById(id)

    fun add(phone: Phone): Phone = phoneRepository.save(phone)

    fun edit(phone: Phone, id: Long): Phone = phoneRepository
            .save(phone.copy(id = id))

    fun remove(id: Long) = phoneRepository.deleteById(id)

}