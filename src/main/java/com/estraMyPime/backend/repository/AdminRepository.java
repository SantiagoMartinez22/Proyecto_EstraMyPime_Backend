package com.estraMyPime.backend.repository;

import org.springframework.stereotype.Repository;

import com.estraMyPime.backend.Model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    
}