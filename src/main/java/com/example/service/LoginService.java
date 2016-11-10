package com.example.service;

import com.example.model.LoginCredentials;
import com.example.repository.LoginRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ashish on 11/8/2016.
 */
@Service
public class LoginService {

    private LoginRepository loginRepository;

    public LoginCredentials getLoginCredentials(String username){
        loginRepository = new LoginRepository();
        return loginRepository.getLoginCredentials(username);
    }

}
