package com.babynameplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wojci on 4/11/2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping(method= RequestMethod.GET)
    public String home(){
        return "home";
    }
}