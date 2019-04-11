package com.bulackiy.restapp.service

import com.bulackiy.restapp.app.Address
import com.bulackiy.restapp.app.AddressRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService(private val addressRepository: AddressRepository) {

    fun all(): Iterable<Address> = addressRepository.findAll()

    fun get(id: Long): Optional<Address> = addressRepository.findById(id)

    fun add(address: Address): Address = addressRepository.save(address)

    fun edit(address: Address, id: Long): Address = addressRepository
            .save(address.copy(id = id))

    fun remove(id: Long) = addressRepository.deleteById(id)
}