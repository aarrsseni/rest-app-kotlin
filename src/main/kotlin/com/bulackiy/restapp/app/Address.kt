package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonIgnore
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

        @JsonIgnore
        @OneToMany(mappedBy = "mainAddress")
        val persons: MutableList<Person> = mutableListOf(),

        @JsonIgnore
        @ManyToMany(mappedBy = "additionalAddresses")
        val additionalPersons: MutableList<Person> = mutableListOf()
)