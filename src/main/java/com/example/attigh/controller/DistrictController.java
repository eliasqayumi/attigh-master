package com.example.attigh.controller;


import com.example.attigh.model.District;
import com.example.attigh.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<District>> getAll() {
        return new ResponseEntity<>(this.districtService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.districtService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<District> insert(@RequestBody District district) {
        return new ResponseEntity<>(this.districtService.insert(district), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> update(@PathVariable Long id, @RequestBody District district) {
        return new ResponseEntity<>(this.districtService.update(id, district), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<District> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.districtService.deleteDistrictById(id), OK);
    }
}
