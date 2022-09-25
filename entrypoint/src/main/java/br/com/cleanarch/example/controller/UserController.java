package br.com.cleanarch.example.controller;

import br.com.cleanarch.example.converter.UserRequestConverter;
import br.com.cleanarch.example.request.UserRequest;
import br.com.cleanarch.example.user.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRequestConverter requestConverter;


    @GetMapping
    public String getUser(){
        return "USER GET";
    }

    @PostMapping
    public void save(@RequestBody UserRequest request){

        var user = requestConverter.toUser(request);
        userService.save(user);
    }
}