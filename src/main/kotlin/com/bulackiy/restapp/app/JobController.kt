package com.bulackiy.restapp.app

import com.bulackiy.restapp.service.JobService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("job")
class JobController(private val jobService: JobService) {

    @GetMapping
    fun index() = jobService.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody job: Job) = jobService.add(job)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = jobService.get(id)
}