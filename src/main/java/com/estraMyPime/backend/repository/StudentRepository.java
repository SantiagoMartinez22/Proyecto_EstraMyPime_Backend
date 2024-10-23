package com.estraMyPime.backend.repository;

import com.estraMyPime.backend.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
