package com.chatApp.ChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatApp.ChatApp.entity.Messages;

public interface MesageRepository extends JpaRepository<Messages,Long>{
    
}
