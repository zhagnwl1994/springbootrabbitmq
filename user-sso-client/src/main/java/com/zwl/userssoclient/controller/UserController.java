package com.zwl.userssoclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @RequestMapping("/getwel")
    public String getWel(){
        return "wel";
    }
}
