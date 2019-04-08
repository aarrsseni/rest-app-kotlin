package com.bulackiy.restapp.service

import com.bulackiy.restapp.app.Product
import com.bulackiy.restapp.app.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun all(): Iterable<Product> = productRepository.findAll()

    fun get(id: Long): Optional<Product> = productRepository.findById(id)

    fun add(product: Product): Product = productRepository.save(product)

    fun edit(product: Product, id: Long): Product = productRepository
            .save(product.copy(id = id))

    fun remove(id: Long) = productRepository.deleteById(id)
}