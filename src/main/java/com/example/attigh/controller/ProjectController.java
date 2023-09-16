package com.example.attigh.controller;


import com.example.attigh.model.Project;
import com.example.attigh.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        return new ResponseEntity<>(this.projectService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.projectService.findById(id), OK);
    }

    @PostMapping
    public ResponseEntity<Project> insert(@RequestBody Project project) {
        return new ResponseEntity<>(this.projectService.insert(project), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project) {
        return new ResponseEntity<>(this.projectService.update(id, project), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.projectService.deleteProjectById(id), OK);
    }
}
