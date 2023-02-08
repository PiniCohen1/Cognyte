package com.epam.examinator.controllers;

import com.epam.examinator.models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/api/hello")
    public String hellsdsdsdsds() {
        return "Hello!!";
    }
    @GetMapping("/api/person")
    public Person getPerson() {

        return new Person("Pini",29);
    }

    @GetMapping("/api/name/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return new Person(name.toLowerCase(),30);
    }
    @GetMapping("/api/name")
    //public Person getPersonByNameRequestParam(@RequestParam("name") String name) {
    public Person getPersonByNameRequestParam(@RequestParam String name) {
        return new Person(name.toUpperCase(),31);
    }
    @PostMapping("/api/person/upper")
    public Person convertToUpperCase(@RequestBody Person person) {
        person.setName(person.getName().toUpperCase());
        return person;
    }
}
