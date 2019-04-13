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

        @JsonProperty("additionalPhones")
        @ManyToMany
        @JoinTable(name = "additionalPhones",
                joinColumns = arrayOf(JoinColumn(name = "personPhoneId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "phonePersonId", referencedColumnName = "id")))
        val additionalPhones: MutableList<Phone> = mutableListOf(),

        @JsonProperty("additionalAddresses")
        @ManyToMany
        @JoinTable(name = "additionalAddresses",
                joinColumns = arrayOf(JoinColumn(name = "personAddressId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "addressPersonId", referencedColumnName = "id")))
        val additionalAddresses: MutableList<Address> = mutableListOf(),

        @ManyToMany
        @JoinTable(name = "additionalJobs",
                joinColumns = arrayOf(JoinColumn(name = "personJobId", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "addressJobId", referencedColumnName = "id")))
        val additionalJobs: MutableList<Job> = mutableListOf(),

        @JsonProperty("mainPhone")
        @ManyToOne
        @JoinColumn(name = "phoneId")
        var mainPhone: Phone? = null,

        @JsonProperty("mainAddress")
        @ManyToOne
        @JoinColumn(name = "addressId")
        var mainAddress: Address? = null,

        @JsonProperty("mainJob")
        @ManyToOne
        @JoinColumn(name = "jobId")
        var mainJob: Job? = null
)