package com.example.firstApi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstApi.models.User;





@RestController
@RequestMapping("/home")
public class Hello {
    @GetMapping
    public String sayHello(){
        return "hello";
    }
     @GetMapping("/greeting")
    public String Hello(){
        return "hello";
    }
    @GetMapping("/user")
    public List<User> listUser(){
        return Arrays.asList(new User(1, "ram", "ram@mail.com"),new User(2, "ravi", "ravi@mail.com"));
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
