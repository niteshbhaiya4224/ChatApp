package com.chatApp.ChatApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatApp.ChatApp.entity.Person;

@Repository
public interface LogInRepository extends JpaRepository<Person,Long> {
    public Person findByusername(String username);
}
