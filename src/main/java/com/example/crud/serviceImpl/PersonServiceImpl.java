package com.example.crud.serviceImpl;

import com.example.crud.dao.PersonDao;
import com.example.crud.entity.Person;
import com.example.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public Person addPerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public List<Person> showPerson() {
        return personDao.findAll();
    }

    @Override
    public Optional<Person> showPersonById(Long id) {
        Optional<Person> person = personDao.findById(id);
        return person;
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deleteById(id);
    }

    @Override
    public Optional<Person> updatePerson(Person person, Long id) {
        Optional<Person> _person = personDao.findById(id);
        if(person.getName()!=null)
            _person.get().setName(person.getName());
        if(person.getPhone()!=null)
            _person.get().setPhone(person.getPhone());
        if(person.getEmail()!=null)
            _person.get().setEmail(person.getEmail());
        personDao.save(_person.get());
        return _person;
    }

}
