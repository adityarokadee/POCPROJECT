package com.example.POC1.logincontroller;

import com.example.POC1.logindomain.login;
import com.example.POC1.loginservice.loginservice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class logincontroller {
    @Autowired
    private loginservice  userservice;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new login());
        return mav;

    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") login user){
        login oauthUser=userservice.login(user.getUsername(),user.getPassword());

        System.out.println(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/";
        }

        else{
            return "redirect:/login";
        }

    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {


        return "redirect:/login";
    }
}



