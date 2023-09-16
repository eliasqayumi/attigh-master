package com.example.attigh.controller;


import com.example.attigh.model.Type;
import com.example.attigh.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/type")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<Type>> getAll() {
        return new ResponseEntity<>(this.typeService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.typeService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Type> insert(@RequestBody Type type) {
        return new ResponseEntity<>(this.typeService.insert(type), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> update(@PathVariable Integer id, @RequestBody Type type) {
        return new ResponseEntity<>(this.typeService.update(id, type), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Type> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.typeService.deleteTypeById(id), OK);
    }
}
