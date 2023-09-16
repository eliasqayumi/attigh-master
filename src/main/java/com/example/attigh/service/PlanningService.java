package com.example.attigh.service;

import com.example.attigh.dto.PlanningDTO;
import com.example.attigh.dto.PlanningRequestDTO;
import com.example.attigh.model.Planning;

import java.util.List;

public interface PlanningService{

    List<Planning> getAll();

    Planning insert(PlanningRequestDTO planning);

    Planning update(Long planningId, Planning planning);

    Planning findById(Long planningId);
    Planning deletePlanningById(Long planningId);

    PlanningDTO getAllPlanningByProjectId(Long projectId);
}
