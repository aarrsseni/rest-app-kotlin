package com.bulackiy.restapp.app

import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long>