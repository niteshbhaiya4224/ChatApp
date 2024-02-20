package com.chatApp.ChatApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Data
public class Messages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String sender;
    String receiver;
    String message;

    public Messages(String sender,  String receiver, String message){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public Messages(){}
}
