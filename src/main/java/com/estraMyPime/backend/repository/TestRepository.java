package com.estraMyPime.backend.repository;

import com.estraMyPime.backend.Model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer> {
}
