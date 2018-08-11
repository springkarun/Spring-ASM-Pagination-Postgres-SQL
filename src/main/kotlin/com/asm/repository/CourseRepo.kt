package com.asm.repository

import com.asm.model.CourseModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepo:JpaRepository<CourseModel,Long>{

}