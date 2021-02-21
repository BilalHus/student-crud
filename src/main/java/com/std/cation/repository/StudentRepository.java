package com.std.cation.repository;

import com.std.cation.model.Group;
import com.std.cation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByGroup(Group group);
}
