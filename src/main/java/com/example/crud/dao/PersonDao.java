package com.example.crud.dao;

import com.example.crud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDao extends JpaRepository<Person, Long> {

    @Override
    @Query(value = "SELECT * FROM person ORDER BY name", nativeQuery = true)
    List<Person> findAll();
}
