package com.mbstu.ict.dao;

import com.mbstu.ict.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select p from Student p where p.id = ?")
    Student getStudentById(Integer studentId);
}