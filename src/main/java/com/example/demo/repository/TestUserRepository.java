package com.example.demo.repository;

import com.example.demo.models.TestMesseges;
import com.example.demo.models.TestUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestUserRepository extends JpaRepository<TestUsers,Integer> {
    TestUsers findTestUsersByLogins(String login);
}
