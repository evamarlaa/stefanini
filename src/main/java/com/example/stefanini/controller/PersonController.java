package com.example.stefanini.controller;

import com.example.stefanini.datasource.model.Person;
import com.example.stefanini.exception.PersonNotFoundException;
import com.example.stefanini.repository.PersonRepository;
import com.example.stefanini.resourcemodel.PersonResource;
import com.example.stefanini.service.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonServiceImplementation personServiceImplementation;

    @GetMapping(path = "/person")
    public List<Person> all() {
        return personServiceImplementation.all();
    }

    @GetMapping(path = "/person/{id}")
    public Person findPersonById(@PathVariable(name = "id", required = true) Long id) throws PersonNotFoundException {
          return personServiceImplementation.findPersonById(id);
    }

    @PostMapping(path = "/person")
    public Person createPerson(@RequestBody PersonResource person) {
        return personServiceImplementation.createPerson(person);
    }

    @DeleteMapping(path = "/person/{id}")
    public void deletePerson(@PathVariable(name = "id", required = true) Long id) throws PersonNotFoundException {
        personServiceImplementation.deleteById(id);
    }

    @PutMapping(path = "/person/{id}")
    public Person updatePerson(@PathVariable(name = "id", required = true) Long id, @RequestBody PersonResource person) {
        return personServiceImplementation.updatePerson(person, id);
    }
}