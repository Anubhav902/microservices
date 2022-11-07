package com.admin.service.adminservice.repository;


import com.admin.service.adminservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    @Modifying
    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> loginUser(@Param("email") String email);

}