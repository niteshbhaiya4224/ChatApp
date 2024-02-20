package com.chatApp.ChatApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chatApp.ChatApp.entity.Person;
import com.chatApp.ChatApp.repository.LogInRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogInController {

    @GetMapping("/")
    public String viewLoginPage(){
        return "login";
    }

    
    @GetMapping("/signup")
    public String viewSignupPage(){
        return "signup";
    }

    @Autowired
    LogInRepository repo;

    @PostMapping("/sendsignupdata")
    public String sendSignup(HttpServletRequest request){
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        Person p1 = new Person(username,email,password,cpassword);
        repo.save(p1);

        return "redirect:/";

    }

    public static Person p1;

    @PostMapping("/sendlogindata")
    public String sendLogin(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        p1 = repo.findByusername(username);
        model.addAttribute("person", p1);
        if(p1==null){
            return "fail";
        }
        else if(p1.getUsername().equals(username) && p1.getPassword().equals(password)){
            return "redirect:/listUsers";
        }
        return "fail";

    }

    @GetMapping("/test")
    public String getLoginData(){
        return "test";
    }


    // We are dealing with this
    
    @GetMapping("/listUsers")
    public String getAllUser(Model model){
        model.addAttribute("person", p1);
        model.addAttribute("users", repo.findAll());
        return "Listuser";
    }
    
}
