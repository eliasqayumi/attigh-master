package com.example.attigh.service;

import com.example.attigh.dto.EtudeListResponseDTO;
import com.example.attigh.dto.EtudeRequestDTO;
import com.example.attigh.model.Etude;

import java.util.List;

public interface EtudeService {

    List<Etude> getAll();

    Etude insert(EtudeRequestDTO etude);

    Etude update(Long etudeId, Etude etude);

    Etude findById(Long etudeId);
    Etude deleteEtudeById(Long etudeId);

    EtudeListResponseDTO getListOfEtudeByProjectId(Long projectId);

}
