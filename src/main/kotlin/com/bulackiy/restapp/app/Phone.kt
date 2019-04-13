package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonIgnore
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

        @JsonIgnore
        @OneToMany(mappedBy = "mainPhone")
        val persons: MutableList<Person> = mutableListOf(),

        @JsonIgnore
        @ManyToMany(mappedBy = "additionalPhones")
        val additionalPersons: MutableList<Person> = mutableListOf()
)