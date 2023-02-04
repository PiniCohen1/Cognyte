package com.epam.examinator.controllers;

import com.epam.examinator.models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello!!";
    }
    @GetMapping("/api/person")
    public Person getPerson() {
        return new Person("Pini");
    }

    @GetMapping("/api/name/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return new Person(name.toLowerCase());
    }
    @GetMapping("/api/name")
    //public Person getPersonByNameRequestParam(@RequestParam("name") String name) {
    public Person getPersonByNameRequestParam(@RequestParam String name) {
        return new Person(name.toUpperCase());
    }
    @PostMapping("/api/person/upper")
    public Person convertToUpperCase(@RequestBody Person person) {
        person.setName(person.getName().toUpperCase());
        return person;
    }
}
