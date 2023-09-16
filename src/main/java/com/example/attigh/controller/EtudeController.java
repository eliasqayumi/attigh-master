package com.example.attigh.controller;


import com.example.attigh.dto.EtudeListResponseDTO;
import com.example.attigh.dto.EtudeRequestDTO;
import com.example.attigh.model.Etude;
import com.example.attigh.service.EtudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/etude")
@RequiredArgsConstructor
public class EtudeController {

    private final EtudeService etudeService;

    @GetMapping
    public ResponseEntity<List<Etude>> getAll() {
        return new ResponseEntity<>(this.etudeService.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etude> getById(@PathVariable Long id) {
        return new ResponseEntity<>(this.etudeService.findById(id), OK);
    }

    @GetMapping("/project")
    public ResponseEntity<EtudeListResponseDTO> getListOfEtudeByProjectId(@RequestParam("projectId") Long projectId){
        return new ResponseEntity<>(this.etudeService.getListOfEtudeByProjectId(projectId),OK);
    }

    @PostMapping
    public ResponseEntity<Etude> insert(@RequestBody EtudeRequestDTO etude) {
        return new ResponseEntity<>(this.etudeService.insert(etude), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etude> update(@PathVariable Long id, @RequestBody Etude etude) {
        return new ResponseEntity<>(this.etudeService.update(id, etude), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Etude> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(this.etudeService.deleteEtudeById(id), OK);
    }

}
