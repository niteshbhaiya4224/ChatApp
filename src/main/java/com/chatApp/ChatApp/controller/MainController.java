package com.chatApp.ChatApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chatApp.ChatApp.entity.Messages;
import com.chatApp.ChatApp.repository.MainRepository;
import com.chatApp.ChatApp.repository.MesageRepository;

@Controller
public class MainController {
    
    @Autowired
    MainRepository repo;
    @Autowired
    MesageRepository repo2;

    public static long currentCount;

    @GetMapping("/messages")
    public String home(Model model){
        // model.addAttribute("person", LogInController.p1); // logined user
        model.addAttribute("users", repo.findAll());
        // System.out.println(LogInController.p1.getUsername());
        // System.out.println(MessageController.receiver);

        List<Object[]> result = repo.getMesagefromusers(LogInController.p1.getUsername(),MessageController.receiver);

        List<Messages> messages = new ArrayList<>();

        for (Object[] objArray : result) {
            Messages message = new Messages((String) objArray[3], (String) objArray[2], (String) objArray[1]);
            messages.add(message);
        }

        // System.out.println(repo.countMessage(LogInController.p1.getUsername(), MessageController.receiver));
        currentCount = messages.size();

        long unread = currentCount-MessageController.getprevCount;

        System.out.println(unread);
        model.addAttribute("unread", unread);
        model.addAttribute("messages", messages);
        return "messages";
    }

/*

session 1
 * count = 13 -> getPrevCount // atleast
 * 
 * currentCount = 17
 * 
 * i d
 * unread = 4
 * 
 * 
 * // session 2
 * 
 * count = 17
 * 
 */
}
