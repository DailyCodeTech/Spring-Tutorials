package com.dailycode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public String home(){
        log.info("[HomeController] : home");
        return "This is home page";
    }

    @GetMapping("/admin")
    public String admin(){
        log.info("[HomeController] : admin");
        return "This is admin page";
    }


}
