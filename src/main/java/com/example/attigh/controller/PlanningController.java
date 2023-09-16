package com.example.attigh.controller;


import com.example.attigh.dto.PlanningDTO;
import com.example.attigh.dto.PlanningRequestDTO;
import com.example.attigh.model.Planning;
import com.example.attigh.service.PlanningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/planning")
@RequiredArgsConstructor
public class PlanningController {

    private final PlanningService planningService;

    @GetMapping
    public ResponseEntity<List<Planning>> getAll() {
        return new ResponseEntity<>(this.planningService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planning> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.planningService.findById(id), OK);
    }

    @GetMapping("/project")
    public ResponseEntity<PlanningDTO> getByProjectId(@RequestParam("projectId") Long projectId) {
        return new ResponseEntity<>(this.planningService.getAllPlanningByProjectId(projectId), OK);
    }

    @PostMapping
    public ResponseEntity<Planning> insert(@RequestBody PlanningRequestDTO planning) {
        return new ResponseEntity<>(this.planningService.insert(planning), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planning> update(@PathVariable Long id, @RequestBody Planning planning) {
        return new ResponseEntity<>(this.planningService.update(id, planning), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Planning> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.planningService.deletePlanningById(id), OK);
    }
}
