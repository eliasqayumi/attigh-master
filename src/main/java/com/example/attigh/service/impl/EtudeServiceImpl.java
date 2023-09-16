package com.example.attigh.service.impl;

import com.example.attigh.dto.EtudeListResponseDTO;
import com.example.attigh.dto.EtudeNeighbourhoodDTO;
import com.example.attigh.dto.EtudeRequestDTO;
import com.example.attigh.model.Etude;
import com.example.attigh.repo.EtudeRepository;
import com.example.attigh.repo.NeighbourhoodRepository;
import com.example.attigh.repo.ProjectRepository;
import com.example.attigh.service.EtudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudeServiceImpl implements EtudeService {
    private final EtudeRepository etudeRepository;
    private final NeighbourhoodRepository neighbourhoodRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<Etude> getAll() {
        return this.etudeRepository.findAll();
    }

    @Override
    public Etude insert(EtudeRequestDTO etude) {

        return this.etudeRepository.save(
                Etude.builder()
                        .neighbourhood(
                                this.neighbourhoodRepository
                                        .findById(etude.getNeighbourhoodId())
                                        .orElseThrow())
                        .project(this.projectRepository.findById(etude.getProjectId()).orElseThrow())
                        .regulationArea(etude.getRegulationArea())
                        .numberOfBlock(etude.getNumberOfBlock())
                        .numberOfBusiness(etude.getNumberOfBusiness())
                        .cadNumberOfParcels(etude.getCadNumberOfParcels())
                        .build()
        );
    }

    @Override
    public Etude update(Long etudeId, Etude etude) {
        Etude modifyEtude = this.findById(etudeId);
        modifyEtude.setNeighbourhood(etude.getNeighbourhood());
        modifyEtude.setRegulationArea(etude.getRegulationArea());
        modifyEtude.setNumberOfBlock(etude.getNumberOfBlock());
        modifyEtude.setNumberOfBusiness(etude.getNumberOfBusiness());
        modifyEtude.setCadNumberOfParcels(etude.getCadNumberOfParcels());
        modifyEtude.setWay(etude.getWay());
        return this.etudeRepository.save(modifyEtude);
    }

    @Override
    public Etude findById(Long etudeId) {
        return this.etudeRepository.findById(etudeId).orElseThrow();
    }

    @Override
    public Etude deleteEtudeById(Long etudeId) {
        Etude deleteEtude = this.findById(etudeId);
        this.etudeRepository.deleteById(etudeId);
        return deleteEtude;
    }

    @Override
    public EtudeListResponseDTO getListOfEtudeByProjectId(Long projectId) {
        List<Etude> etudes = this.etudeRepository.findAllByProject_id(projectId);
        return etudes!=null && !etudes.isEmpty() ?
                EtudeListResponseDTO.builder()
                        .projectName(etudes.get(0).getProject().getProjectName())
                        .neighbourhoods(etudes.stream().map(this::getEtudeNeighbourhoodBuild).toList())
                        .build(): null;
    }

    private EtudeNeighbourhoodDTO getEtudeNeighbourhoodBuild(Etude etude) {
        return EtudeNeighbourhoodDTO.builder()
                .neighbourhoodName(etude.getNeighbourhood().getNeighbourhoodName())
                .regulationArea(etude.getRegulationArea())
                .numberOfBlock(etude.getNumberOfBlock())
                .numberOfBusiness(etude.getNumberOfBusiness())
                .cadNumberOfParcels(etude.getCadNumberOfParcels())
                .way(etude.getWay())
                .build();
    }
}
