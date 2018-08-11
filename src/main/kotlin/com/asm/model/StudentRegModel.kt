package com.asm.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "reg_student")
open class StudentRegModel(


        @Column(name = "dept", length = 8)
        open val dept: String? = null,

        @Column(name = "fname", length = 20)
        open val fname: String? = null,

        @Column(name = "lname" ,length = 20)
        open val lname: String? = null,


        @Column(name = "email", length = 40, unique = true, nullable = true)
        open val email: String? = null,

        @Column(name = "mobile", length = 12, unique = true)
        open val mobile: String? = null,

        @Column(name = "gender", length = 6)
        open val gender: String? = null,

        @Column(name = "age", length = 2)
        open val age: Int? = null,

        @Column(name = "city", length = 30)
        open val city: String? = null,

        @Column(name = "avatar")
        open val avatar: String? = null,


        @Column(name = "date")
        open val date: LocalDate? = null,

        @Column(name = "stu_id", length = 10, unique = true)
        open val stu_id: String? = null,


        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        open val id: Long = -1) : Serializable {
    private constructor() : this("", "", "", "", "", "", 0, "",
            "")
}