package com.chatApp.ChatApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chatApp.ChatApp.entity.User;

@Repository
public interface MainRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM messages WHERE sender = :cuser AND receiver = :muser OR sender = :muser and receiver = :cuser", nativeQuery = true)
    public List<Object[]> getMesagefromusers(String cuser, String muser);

    @Query(value = "Select count(message) from messages where sender = :cuser and receiver = :muser or Sender = :muser and Receiver = :cuser",nativeQuery = true)
    public long countMessage(String cuser, String muser);
}
