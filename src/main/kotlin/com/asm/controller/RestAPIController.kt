package com.asm.controller

import com.asm.service.CourseService
import com.asm.service.StudentRegService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = ["api"])
class RestAPIController{

    @Autowired
    private lateinit var regiService: StudentRegService

    @Autowired
    private lateinit var regiCourse: CourseService


     @PostMapping("/createCourse")
     fun createCouse(@RequestBody body:Map<String,String>):Any{
        return regiCourse.registerCourse(body)
     }

    @GetMapping("/allCourse")
    fun allCourse():Any =regiCourse.allCourse()

    @PostMapping("/createReg")
     fun createRegi(@RequestBody body:Map<String,String>):Any{
        return regiService.registerMCA(body)
    }


     @GetMapping("/allStudent")
     fun allStudent():Any =regiService.getAllStudent()



    /* Pagination    http://localhost:8080/api/listPageable?page=0&size=2&sort=fname    */
    @GetMapping("/listPageable")
    fun allStudent(pageable: Pageable):Any =regiService.getAllStudent(pageable)



    @GetMapping("/findByDept/{dept}")
     fun findByDept(@PathVariable("dept") dept:String):Any =regiService.findByDept(dept)


    @GetMapping("/search")
    fun registation23():Any{
        val list=ArrayList<Model>()
        list.add(Model("Rose pink","https://www.fiftyflowers.com/site_files/FiftyFlowers/Image/Product/Hot-Lady2-350_de950408.jpg"))
        list.add(Model("Noicey Lity","https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Liliumbulbiferumflowertop.jpg/220px-Liliumbulbiferumflowertop.jpg"))
        list.add(Model("Rose Lity","https://images.pexels.com/photos/63638/roses-flower-nature-macro-63638.jpeg?auto=compress&cs=tinysrgb&h=350"))
        list.add(Model("Rose Pokt","https://elisadiogodossantos.files.wordpress.com/2009/09/fotos-flores-rosas.jpg"))
        list.add(Model("Yesy Noinde Pokt","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxUO4Vv6ljuBT7n3uBtgRnjgLsU-GMwXfqc-Xa4xQKEm-ZddTudg"))
        list.add(Model("Rose volie","https://nurserylive.com/images/stories/virtuemart/product/nurserylive-Miniature-Rose-Button-Rose-Pink-Plant.jpg"))
        list.add(Model("Rose onaine ","https://www.desicomments.com/wp-content/uploads/2017/02/Nice-Rose.png"))
        list.add(Model("Mohani Okd  ","https://www.publicdomainpictures.net/pictures/10000/velka/1-1254836694ahTH.jpg"))

        list.add(Model("Tumesh onaine ","https://www.flyingflowers.co.uk/ff_images/product/222/FC01302F_18.jpg?category"))
        list.add(Model("Sonika Mouayb ","https://images.pexels.com/photos/87840/daisy-pollen-flower-nature-87840.jpeg?cs=srgb&dl=bloom-blossom-close-up-87840.jpg&fm=jpg"))
        list.add(Model("Soyando fonds ","https://images.all-free-download.com/images/graphiclarge/butterfly_flower_01_hd_pictures_166973.jpg"))
        return list
    }



/*

    @GetMapping("/test")
    fun getMess():String="Hello"
*/


}

data class Model(val name:String,val avatar:String)