package com.example.stefanini.service;

import com.example.stefanini.datasource.model.Person;
import com.example.stefanini.exception.PersonNotFoundException;
import com.example.stefanini.repository.PersonRepository;
import com.example.stefanini.resourcemodel.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonConversor personConversor;

    public List<Person> all() {
        List <Person> peopleList = personRepository.findAll();
        return peopleList;
    }

    public Person createPerson(PersonResource personResource) {
        try {
            Person person = personConversor.conversor(personResource);
            return personRepository.saveAndFlush(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person findPersonById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = null;
        if (!optionalPerson.isPresent()) throw new PersonNotFoundException("Person not found!");
        else person = optionalPerson.get();
        return person;
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = null;
        if (!optionalPerson.isPresent()) throw new PersonNotFoundException("Person not found!");
        else personRepository.delete(optionalPerson.get());
    }

    public Person updatePerson(PersonResource personResource, Long id) {
        try {
            Optional<Person> optionalPerson = personRepository.findById(id);
            Person person = null;
            if (!optionalPerson.isPresent()) throw new PersonNotFoundException("Person not found!");
            else person = optionalPerson.get();
            Person personValidated = personConversor.conversorUpdate(personResource, person);
            return personRepository.save(personValidated);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
