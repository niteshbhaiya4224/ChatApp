package com.chatApp.ChatApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.chatApp.ChatApp.entity.Messages;
import com.chatApp.ChatApp.repository.MainRepository;
import com.chatApp.ChatApp.repository.MesageRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MessageController {
    public static Messages m1;
    public static String receiver;
    @Autowired
    MesageRepository repo;
    @Autowired
    MainRepository repo2;

    public static long getprevCount;

    @PostMapping("/get") // List user button
    public String getData(HttpServletRequest request){
        String from = LogInController.p1.getUsername(); // Nitesh
        receiver = request.getParameter("muser"); // abhi
        
        getprevCount = repo2.countMessage(LogInController.p1.getUsername(), receiver);

        m1 = new Messages(from,receiver,null);
        return "redirect:/messages";
    }

    @PostMapping("/getM") // SendMessage
    public String getMesageData(HttpServletRequest request){
        String sender = LogInController.p1.getUsername();
        String message = request.getParameter("message");
        m1 = new Messages(sender,receiver,message);
        repo.save(m1);
        return "redirect:/messages";
    }
}
