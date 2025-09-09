package com.example.firstApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class Hello {
    @GetMapping
    public String sayHello(){
        return "hello";
    }

    
}

@RestController
@RequestMapping("/test")
 class Test{
    @GetMapping
    public String test(){
        return "test";
    }
}
