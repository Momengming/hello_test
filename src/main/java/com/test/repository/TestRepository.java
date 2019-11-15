package com.test.repository;

import com.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,Integer> {
    public List<Test> findByAge(int age);
}
