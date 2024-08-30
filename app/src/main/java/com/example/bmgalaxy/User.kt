package com.example.bmgalaxy

import java.time.LocalDate



// User class
class User {
    var id: String = ""
    var name: String = ""
    var contact: String = ""
    var address: String = ""
    var doj: LocalDate? = null
    var dueDate: LocalDate? = null
    var role: UserRole? = null
    var isActive: Boolean=false

    constructor()

    constructor(
        id: String,
        name: String,
        contact: String,
        address: String,
        doj: LocalDate,
        dueDate: LocalDate,
        role: UserRole,
        isActive:Boolean
    ) {
        this.id = id
        this.name = name
        this.contact = contact
        this.address = address
        this.doj = doj
        this.dueDate = dueDate
        this.role = role
        this.isActive=isActive
    }
}