package com.admin.service.adminservice.controller;


import com.admin.service.adminservice.model.User;
import com.admin.service.adminservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService service;
    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping(value = "/add-user")
    public String signup(@RequestBody User user){
        return service.signupService(user);
    }


    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map){
        return service.loginService(map.get("email").toString(), map.get("password").toString());
    }

    @GetMapping("/get-users")
    public List<User> getUsers(){
        return service.getUsers();
    }

}