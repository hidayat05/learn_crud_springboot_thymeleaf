package com.kipli.learnspring.samples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping("/page")
    public String helloPage(Model model){
        model.addAttribute("theDate", new Date());
        return "helloworld";
    }


}
