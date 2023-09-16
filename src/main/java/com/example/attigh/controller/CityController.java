package com.example.attigh.controller;


import com.example.attigh.model.City;
import com.example.attigh.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(this.cityService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.cityService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<City> insert(@RequestBody City city) {
        return new ResponseEntity<>(this.cityService.insert(city), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Integer id, @RequestBody City city) {
        return new ResponseEntity<>(this.cityService.update(id, city), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.cityService.deleteCityById(id), OK);
    }
}
