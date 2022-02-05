package com.example.backendapp.controller;

import com.example.backendapp.model.Person;
import com.example.backendapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/people")
//    public ResponseEntity<List<Person>> getAllPeople(){
//        try{
//            List<Person> persons = new ArrayList<Person>();
//
//            personRepository.findAll().forEach(persons::add);
//
//            if (persons.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(persons, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }
}
