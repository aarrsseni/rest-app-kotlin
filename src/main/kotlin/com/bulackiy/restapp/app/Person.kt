package com.bulackiy.restapp.app

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.JoinColumn



@Entity
@Table(name = "person")
data class Person(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @JsonProperty("firstName")
        @Column(name = "firstName", length = 1000)
        val firstName: String,

        @JsonProperty("lastName")
        @Column(name = "lastName", length = 1000)
        val lastName: String,

        @JsonProperty("patronymic")
        @Column(name = "patronymic", length = 1000)
        val patronymic: String,

        @JsonProperty("dateOfBirth")
        @Column(name = "dateOfBirth")
        val dateOfBirth: LocalDate,

        @ManyToMany
        @JoinTable(name = "additionalPhones",
                joinColumns = arrayOf(JoinColumn(name = "personPhoneId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "phonePersonId", referencedColumnName = "id")))
        var additionalPhones: List<Phone> = mutableListOf(),

        @ManyToMany
        @JoinTable(name = "additionalAddresses",
                joinColumns = arrayOf(JoinColumn(name = "personAddressId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "addressPersonId", referencedColumnName = "id")))
        var additionalAddresses: List<Address> = mutableListOf(),

        @ManyToMany
        @JoinTable(name = "additionalJobs",
                joinColumns = arrayOf(JoinColumn(name = "personJobId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "addressJobId", referencedColumnName = "id")))
        var additionalJobs: List<Job> = mutableListOf(),

        @ManyToOne
        @JoinColumn(name = "phoneId")
        var mainPhone: Phone? = null,

        @ManyToOne
        @JoinColumn(name = "addressId")
        var mainAddress: Address? = null,

        @ManyToOne
        @JoinColumn(name = "jobId")
        var mainJob: Job? = null
)