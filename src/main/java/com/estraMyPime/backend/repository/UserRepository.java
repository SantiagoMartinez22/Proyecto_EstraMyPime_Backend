package com.estraMyPime.backend.repository;



import com.estraMyPime.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);
}


