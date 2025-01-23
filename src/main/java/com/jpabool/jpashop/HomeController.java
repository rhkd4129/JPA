package com.jpabool.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }
}
