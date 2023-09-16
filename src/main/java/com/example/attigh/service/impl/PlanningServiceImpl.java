package com.example.attigh.service.impl;

import com.example.attigh.dto.DistrictPlanningDTO;
import com.example.attigh.dto.PlanningDTO;
import com.example.attigh.dto.PlanningRequestDTO;
import com.example.attigh.model.District;
import com.example.attigh.model.Planning;
import com.example.attigh.repo.DistrictRepository;
import com.example.attigh.repo.PlanningRepository;
import com.example.attigh.repo.ProjectRepository;
import com.example.attigh.service.PlanningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class PlanningServiceImpl implements PlanningService {

    private final PlanningRepository planningRepository;
    private final ProjectRepository projectRepository;
    private final DistrictRepository districtRepository;

    @Override
    public List<Planning> getAll() {
        return this.planningRepository.findAll();
    }

    @Override
    public Planning insert(PlanningRequestDTO planning) {
        return this.planningRepository.save(
                Planning.builder()
                        .project(this.projectRepository.findById(planning.getProjectId()).orElseThrow())
                        .district(this.districtRepository.findById(planning.getDistrictId()).orElseThrow())
                        .area(planning.getArea())
                        .build()
        );
    }

    @Override
    public Planning update(Long planningId, Planning planning) {
        //project olmalı mı ?
        Planning modifyPlanning = this.findById(planningId);
        modifyPlanning.setDistrict(modifyPlanning.getDistrict());
        modifyPlanning.setArea(modifyPlanning.getArea());
        return this.planningRepository.save(modifyPlanning);
    }

    @Override
    public Planning findById(Long planningId) {
        return this.planningRepository.findById(planningId).orElseThrow();
    }

    @Override
    public Planning deletePlanningById(Long planningId) {
        Planning deletePlanning = this.findById(planningId);
        this.planningRepository.deleteById(planningId);
        return deletePlanning;
    }

    @Override
    public PlanningDTO getAllPlanningByProjectId(Long projectId) {
        List<Planning> plannings = this.planningRepository.findAllByProject_Id(projectId);
        return plannings != null && !plannings.isEmpty() ? PlanningDTO.builder()
                .project(plannings.get(0).getProject())
                .districts(
                        plannings.stream().map(planning -> DistrictPlanningDTO
                                .builder()
                                .districtName(planning.getDistrict().getDistrictName())
                                .area(planning.getArea())
                                .build()
                        ).toList()
                ).build() : null;
    }

}
