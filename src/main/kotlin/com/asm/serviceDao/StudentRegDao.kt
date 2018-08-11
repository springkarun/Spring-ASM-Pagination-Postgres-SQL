package com.asm.serviceDao

import com.asm.model.StudentRegModel
import com.asm.model.ResponseModel
import com.asm.repository.StudentRegRepo
import com.asm.service.StudentRegService
import com.asm.utils.Constant
import com.asm.utils.Constant.emptyArrays
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service("StudentRegService")
class StudentRegDao : StudentRegService {


    @Autowired
    lateinit var regRepo :StudentRegRepo

    override fun registerMCA(map: Map<String, String>): Any {
        val date: LocalDate? = LocalDate.now()
        val dept= map["dept"]
        val stu_id = dept!!.substring(0,3).toUpperCase()+(Math.random() * 1000).toInt()
        regRepo.save(StudentRegModel(
                dept,map["fname"]!!.toUpperCase(),
                map["lname"]!!.toUpperCase(),
                map["email"]!!.toLowerCase(),
                map["mobile"],
                map["gender"],
                map["age"]!!.toInt(),
                map["city"],map["avatar"],
                date,stu_id))
        val res="register updated"
        return ResponseEntity(ResponseModel(true, Constant.regOK +" Your Id : $stu_id ", res), Constant.CREATED)
    }


    override fun getAllStudent(): Any {
        val res=regRepo.findAll()
        if(!res.isEmpty()){
            val s="total_size : "+res.size
            return ResponseEntity(ResponseModel(true,s, res), Constant.OK)
        }
        return ResponseEntity(ResponseModel(false, Constant.dataEmpty, emptyArrays), Constant.OK)
    }


    // Pagegination........
    override fun getAllStudent(pageable: Pageable):Any {
        val res=regRepo.findAll(pageable)
        return ResponseEntity(ResponseModel(true,"", res), Constant.OK)


    }







    override fun findByDept(dept: String): Any {

        val res=regRepo.findByDept(dept)
        if(!res.isEmpty()){
            val s="total_size : "+res.size
            return ResponseEntity(ResponseModel(true,s, res), Constant.OK)
        }
        return ResponseEntity(ResponseModel(false, Constant.dataEmpty, emptyArrays), Constant.OK)

    }

}