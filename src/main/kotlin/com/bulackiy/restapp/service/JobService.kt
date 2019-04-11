package com.bulackiy.restapp.service

import com.bulackiy.restapp.app.Job
import com.bulackiy.restapp.app.JobRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class JobService(private val jobRepository: JobRepository) {

    fun all(): Iterable<Job> = jobRepository.findAll()

    fun get(id: Long): Optional<Job> = jobRepository.findById(id)

    fun add(job: Job): Job = jobRepository.save(job)

    fun edit(job: Job, id: Long): Job = jobRepository
            .save(job.copy(id = id))

    fun remove(id: Long) = jobRepository.deleteById(id)

}