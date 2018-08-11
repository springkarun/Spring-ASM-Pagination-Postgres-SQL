package com.asm.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "reg_course")
class CourseModel(

        @Column(name = "crs_name", length = 8,unique = true )
        val crs_name: String?=null,

        @Column(name = "crs_id",length = 8,unique = true)
        val crs_id: String?=null,

        @Column(name = "date")
        val date:LocalDate?=null,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1):Serializable
{
        private constructor() : this( "")
}

