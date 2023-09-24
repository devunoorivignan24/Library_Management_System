package com.example.Library_Management_System.Repository;

import com.example.Library_Management_System.Enum.Gender;
import com.example.Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


        List<Student> findByGender(Gender gender);
}
