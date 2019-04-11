package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "address")
data class Address(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @JsonProperty("description")
        @Column(name = "description", length = 1000)
        val description: String,

        @OneToMany(mappedBy = "mainAddress")
        var persons: List<Person> = mutableListOf(),

        @ManyToMany(mappedBy = "additionalAddresses")
        var additionalPersons: List<Person> = mutableListOf()
)