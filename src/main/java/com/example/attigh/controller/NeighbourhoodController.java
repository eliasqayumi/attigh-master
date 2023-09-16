package com.example.attigh.controller;

import com.example.attigh.model.Neighbourhood;
import com.example.attigh.service.NeighbourhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/neighbourhood")
@RequiredArgsConstructor
public class NeighbourhoodController {


    private final NeighbourhoodService neighbourhoodService;

    @GetMapping
    public ResponseEntity<List<Neighbourhood>> getAll() {
        return new ResponseEntity<>(this.neighbourhoodService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Neighbourhood> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.neighbourhoodService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Neighbourhood> insert(@RequestBody Neighbourhood district) {
        return new ResponseEntity<>(this.neighbourhoodService.insert(district), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Neighbourhood> update(@PathVariable Long id, @RequestBody Neighbourhood neighbourhood) {
        return new ResponseEntity<>(this.neighbourhoodService.update(id, neighbourhood), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Neighbourhood> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.neighbourhoodService.deleteNeighbourhoodById(id), OK);
    }
}
