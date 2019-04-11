package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "job")
data class Job(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @JsonProperty("description")
        @Column(name = "description", length = 1000)
        val description: String,

        @OneToMany(mappedBy = "mainJob")
        var persons: List<Person> = mutableListOf(),

        @ManyToMany(mappedBy = "additionalJobs")
        var additionalPersons: List<Person> = mutableListOf()
)