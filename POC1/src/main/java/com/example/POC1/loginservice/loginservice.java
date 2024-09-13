package com.example.POC1.loginservice;

import com.example.POC1.logindomain.login;
import com.example.POC1.loginrepository.loginrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginservice {

    @Autowired
    private loginrepository repo;

    public login login(String username, String password) {
        login user = repo.findByUsernameAndPassword(username, password);
        return user;
    }



}
