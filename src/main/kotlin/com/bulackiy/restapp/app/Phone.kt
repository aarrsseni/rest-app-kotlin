package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "phone")
data class Phone(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @JsonProperty("phoneNumber")
        @Column(name = "phoneNumber", length = 1000)
        val phoneNumber: String,

        @OneToMany(mappedBy = "mainPhone")
        var persons: List<Person> = mutableListOf(),

        @ManyToMany(mappedBy = "additionalPhones")
        var additionalPersons: List<Person> = mutableListOf()
)