package com.example.attigh.controller;


import com.example.attigh.model.Registration;

import com.example.attigh.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<Registration>> getAll() {
        return new ResponseEntity<>(this.registrationService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.registrationService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Registration> insert(@RequestBody Registration registration) {
        return new ResponseEntity<>(this.registrationService.insert(registration), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> update(@PathVariable Long id, @RequestBody Registration registration) {
        return new ResponseEntity<>(this.registrationService.update(id, registration), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Registration> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.registrationService.deleteRegistrationById(id), OK);
    }
}
