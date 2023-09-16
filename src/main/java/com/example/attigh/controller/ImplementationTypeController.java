package com.example.attigh.controller;


import com.example.attigh.model.ImplementationType;
import com.example.attigh.service.ImplementationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/implementationType")
@RequiredArgsConstructor
public class ImplementationTypeController {

    private final ImplementationTypeService implementationTypeService;

    @GetMapping
    public ResponseEntity<List<ImplementationType>> getAll() {
        return new ResponseEntity<>(this.implementationTypeService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImplementationType> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.implementationTypeService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<ImplementationType> insert(@RequestBody ImplementationType implementationType) {
        return new ResponseEntity<>(this.implementationTypeService.insert(implementationType), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImplementationType> update(@PathVariable Integer id, @RequestBody ImplementationType implementationType) {
        return new ResponseEntity<>(this.implementationTypeService.update(id, implementationType), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImplementationType> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.implementationTypeService.deleteImplementationTypeById(id), OK);
    }
}
