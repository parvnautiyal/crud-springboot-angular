package com.example.crud.controller;

import com.example.crud.entity.Person;
import com.example.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        try {
            Person _person = personService.addPerson(person);
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> showPersons() {
        try {
            return new ResponseEntity<>(personService.showPerson(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Optional<Person>> showPersonById(@PathVariable("id") Long id) {
        try {
            if (personService.showPersonById(id).isPresent())
                return new ResponseEntity<>(personService.showPersonById(id), HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/person/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> deletePersonById(@PathVariable("id") Long id) {
        try {
            if (personService.showPersonById(id).isPresent()) {
                personService.deletePerson(id);
                return new ResponseEntity<>("Entry with id "+id+" has been deleted", HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Optional<Person>> updatePersonById(@PathVariable("id") Long id, @RequestBody Person person){
        try{
            if (personService.showPersonById(id).isPresent()) {
                return new ResponseEntity<>( personService.updatePerson(person,id),HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
