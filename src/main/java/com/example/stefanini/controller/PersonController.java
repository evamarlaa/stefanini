package com.example.stefanini.controller;

import com.example.stefanini.datasource.model.Person;
import com.example.stefanini.exception.PersonNotFoundException;
import com.example.stefanini.repository.PersonRepository;
import com.example.stefanini.resourcemodel.PersonResource;
import com.example.stefanini.service.PersonServiceImplementation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
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

//    @PutMapping(path = "/person/{id}")
//    public Person updatePerson(@PathVariable(name = "id", required = true) Long id, @RequestBody PersonResource person) {
//        return personServiceImplementation.updatePerson(person, id);
//    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable(value = "id") Long id, @Valid @RequestBody Person person)
            throws PersonNotFoundException {

        Person p = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found on :: " + id));

        p.setEmail(person.getEmail());

        final Person updatedPerson = personRepository.save(p);
        return ResponseEntity.ok(updatedPerson);
    }
}
