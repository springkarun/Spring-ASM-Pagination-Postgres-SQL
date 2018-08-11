package com.asm.serviceDao

import com.asm.model.CourseModel
import com.asm.model.ResponseModel
import com.asm.repository.CourseRepo
import com.asm.service.CourseService
import com.asm.utils.Constant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service("courseService")
class CourseDao : CourseService {

    @Autowired
    lateinit var regRepo : CourseRepo

    override fun registerCourse(map: Map<String, String>): Any {
        val date: LocalDate? = LocalDate.now()
        val crs_name=map["crs_name"]
        val crs_id = crs_name!!.toLowerCase() +(Math.random() * 10).toInt()
        regRepo.save(CourseModel(crs_name,crs_id,date))
        val res=regRepo.findAll()
        return ResponseEntity(ResponseModel(true, Constant.regOK, res), Constant.CREATED)
    }

    override fun allCourse(): Any {
        val res=regRepo.findAll()
        if(!res.isEmpty()){
            val s="total_size : "+res.size
            return ResponseEntity(ResponseModel(true,s, res), Constant.OK)
        }
        return ResponseEntity(ResponseModel(false, Constant.dataEmpty, Constant.emptyArrays), Constant.OK)

    }


}