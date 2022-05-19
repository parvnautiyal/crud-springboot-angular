package com.example.crud.service;

import com.example.crud.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person addPerson(Person person);

    List<Person> showPerson();

    Optional<Person> showPersonById(Long id);

    void deletePerson(Long id);

    Optional<Person> updatePerson(Person person, Long id);

}
