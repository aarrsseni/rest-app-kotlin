package com.bulackiy.restapp.app

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository

interface PersonRepository: CrudRepository<Person, Long>

interface AddressRepository: CrudRepository<Address, Long>

interface JobRepository: CrudRepository<Job, Long>

interface PhoneRepository: CrudRepository<Phone, Long>
