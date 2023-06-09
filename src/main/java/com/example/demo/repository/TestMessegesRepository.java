package com.example.demo.repository;

import com.example.demo.models.TestMesseges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestMessegesRepository extends JpaRepository<TestMesseges,Integer> {
    List<TestMesseges> findByTheme_Id(Integer id);
}
