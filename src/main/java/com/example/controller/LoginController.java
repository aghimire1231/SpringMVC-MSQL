package com.example.controller;

import com.example.model.LoginCredentials;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ashish on 11/8/2016.
 */
@SuppressWarnings("unused")
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value = "loginProcess",method = RequestMethod.POST)
    public String processLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
        System.out.println(username + ": " + password);

        LoginCredentials credentials = loginService.getLoginCredentials(username);
        //DRY -> Don't Repeat Yourself
        //KISS -> keep it simple stupid
        if(credentials == null){
            return "redirect:/loginError";
        }
//        System.out.println(credentials);
        if (credentials.getPassword().equals(password) ) {
            return "redirect:/loginSuccess";
        } else {
            return "redirect:/loginError";
        }
       /* elseif {
            return "redirect:/login";
        }*/
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @RequestMapping("/loginError")
    public String loginError(){
        return "loginError";
    }


}
