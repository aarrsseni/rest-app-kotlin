package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(

    @JsonProperty("name")
    @Column(name = "name", length = 200)
    val name: String = "",

    @JsonProperty("description")
    @Column(name = "description", length = 1000)
    val description: String = "",

    @Id
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L
)