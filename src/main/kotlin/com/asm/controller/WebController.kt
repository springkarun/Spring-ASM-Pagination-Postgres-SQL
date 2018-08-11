package com.asm.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/")
class WebController {

    @GetMapping("/")
    fun home(): String ="index"


    @GetMapping("/allStudent")
    fun details(): String ="details"


    @GetMapping("/createReg")
    fun registation(): String ="regisation"







    /*@RequestMapping("/")
    fun login(modelAndView: ModelAndView): ModelAndView {
        modelAndView.viewName = "index"
        return modelAndView
    }

*/
   /* @RequestMapping("home")
    internal fun home(modelAndView11: ModelAndView): ModelAndView {
        modelAndView11.viewName = "home"
        return modelAndView11
    }*/
}