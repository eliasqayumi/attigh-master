package com.example.attigh.controller;


import com.example.attigh.model.BuildingConstruction;
import com.example.attigh.service.BuildingConstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/buildingConstruction")
@RequiredArgsConstructor
public class BuildingConstructionController {

    private final BuildingConstructionService buildingConstructionService;

    @GetMapping
    public ResponseEntity<List<BuildingConstruction>> getAll() {
        return new ResponseEntity<>(this.buildingConstructionService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingConstruction> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.buildingConstructionService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<BuildingConstruction> insert(@RequestBody BuildingConstruction buildingConstruction) {
        return new ResponseEntity<>(this.buildingConstructionService.insert(buildingConstruction), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingConstruction> update(@PathVariable Long id, @RequestBody BuildingConstruction buildingConstruction) {
        return new ResponseEntity<>(this.buildingConstructionService.update(id, buildingConstruction), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BuildingConstruction> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.buildingConstructionService.deleteBuildingConstructionById(id), OK);
    }
}
