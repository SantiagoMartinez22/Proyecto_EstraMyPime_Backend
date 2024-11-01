package com.estraMyPime.backend.repository;

import com.estraMyPime.backend.Model.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findByIdEmpresa(String idEmpresa);
}

