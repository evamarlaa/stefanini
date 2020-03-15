package com.example.stefanini.service;

import com.example.stefanini.datasource.model.Person;
import com.example.stefanini.exception.PersonResourceException;
import com.example.stefanini.resourcemodel.PersonResource;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PersonConversor {

    public Person conversor  (PersonResource personResource) throws PersonResourceException {
        try {
            Person p = new Person();

            LocalDate birthday = validateBirthay(personResource.getBirthday());
            p.setBirthday(birthday);

            String email = validateEmail(personResource.getEmail());
            p.setEmail(personResource.getEmail()); //n obg, validado

            String cpf = validateCpf(personResource.getCpf());
            p.setCpf(personResource.getCpf()); //obg, validado

            p.setGender(personResource.getGender());
            p.setName(personResource.getName());
            p.setNationality(personResource.getNationality());
            p.setPlaceOfBirth(personResource.getPlaceOfBirth());

            return p;
        } catch (Exception e) {
            throw new PersonResourceException("Failed to convert resource to entity, resource: " + personResource);
        }
    }

        public Person conversorUpdate (PersonResource personResource, Person p) throws PersonResourceException {
                if (personResource.getBirthday() != null && !personResource.getBirthday().isEmpty()) {
                    LocalDate birthday = validateBirthay(personResource.getBirthday());
                    p.setBirthday(birthday);
                }

                if (personResource.getEmail() != null && !personResource.getEmail().isEmpty()) {
                    String email = validateEmail(personResource.getEmail());
                    p.setEmail(personResource.getEmail()); //n obg, validado
                }

                if (personResource.getCpf() != null && !personResource.getCpf().isEmpty()) {
                    String cpf = validateCpf(personResource.getCpf());
                    p.setCpf(personResource.getCpf()); //obg, validado
                }

                //p.setGender(personResource.getGender());

                return p;
        }

    private String validateEmail(String email) {
        
        if (email != "") {
            return email;
        }
        return "";
    }

    private String validateCpf(String cpf) {
        return cpf;
    }

    private LocalDate validateBirthay(String birthday) {
        return LocalDate.parse(birthday);
    }
}
