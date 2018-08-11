package com.asm.repository

import com.asm.model.StudentRegModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


interface StudentRegRepo:JpaRepository<StudentRegModel,Long>{

    fun findByDept(dept:String):List<StudentRegModel>


}