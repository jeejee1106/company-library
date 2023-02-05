package com.example.companylibrary.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.companylibrary.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}


