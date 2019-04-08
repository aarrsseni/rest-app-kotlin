package com.bulackiy.restapp.app

import com.bulackiy.restapp.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("products")
class ProductsController(private val productService: ProductService) {

    @GetMapping
    fun index() = productService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody product: Product) = productService.add(product)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = productService.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product) =
            productService.edit(product, id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = productService.remove(id)
}