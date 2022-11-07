package com.admin.service.adminservice.service;


import com.admin.service.adminservice.model.User;
import com.admin.service.adminservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String signupService(User user){

        //System.out.println(authConsumer.welcome());
        User savedUser = userRepository.save(user);
        return "User Created" + savedUser;
    }

    public String loginService(String email, String password){
        List<User> foundUsers =  userRepository.loginUser(email);

        if(foundUsers.isEmpty()){
            return "USER NOT FOUND";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "Password Incorrect";
        }

        return "Name : " + foundUsers.get(0).getName()+",\n"+
                "id : " + foundUsers.get(0).getId()+",\n"+
                "Email : " + foundUsers.get(0).getEmail();

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}