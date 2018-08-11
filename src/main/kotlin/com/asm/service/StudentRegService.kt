package com.asm.service

import org.springframework.data.domain.Pageable


interface StudentRegService{

    fun registerMCA(map:Map<String,String>):Any

    fun getAllStudent():Any

    fun getAllStudent(pageable: Pageable):Any

    fun findByDept(dept:String):Any

}