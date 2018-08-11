package com.asm.service


interface CourseService{

    fun registerCourse(map:Map<String,String>):Any

    fun allCourse():Any
}