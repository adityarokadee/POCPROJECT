package com.example.POC1.loginrepository;

import com.example.POC1.logindomain.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginrepository extends JpaRepository<login,Long> {
    login findByUsernameAndPassword(String username, String password);
}


