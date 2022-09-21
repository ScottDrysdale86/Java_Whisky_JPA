package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepo;

    @GetMapping(value="/whisky/year")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name="year") int year){
        return new ResponseEntity<>(whiskyRepo.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value="/whisky/distillery/age")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(@RequestParam(name="name") String name, @RequestParam(name="age") int age){
        return new ResponseEntity<>(whiskyRepo.findByDistilleryNameAndAge(name, age), HttpStatus.OK);
    }

    @GetMapping(value="/whisky/distillery/region")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name="region") String region){
        return new ResponseEntity<>(whiskyRepo.findByDistilleryRegion(region), HttpStatus.OK);
    }



}
