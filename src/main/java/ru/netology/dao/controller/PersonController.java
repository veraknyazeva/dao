package ru.netology.dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.entity.Person;
import ru.netology.dao.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("person/by/city")
    public List<Person> findPersonByCity(@RequestParam String city) {
        return personRepository.findPersonByCityOfLiving(city);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> findPerson(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findPersonByPersonsPK_NameAndPersonsPK_Surname(name, surname);
    }

    @GetMapping("person/by/age")
    public List<Person> findAge(@RequestParam Long age) {
        return personRepository.findAllByPersonsPK_AgeLessThanOrderByPersonsPK_ageAsc(age);
    }
}
