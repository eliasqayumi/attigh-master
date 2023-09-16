package com.example.attigh.service;

import com.example.attigh.model.BuildingConstruction;

import java.util.List;

public interface BuildingConstructionService {

    List<BuildingConstruction> getAll();

    BuildingConstruction insert(BuildingConstruction buildingConstruction);

    BuildingConstruction update(Long buildingConstructionId, BuildingConstruction buildingConstruction);

    BuildingConstruction findById(Long buildingConstructionId);

    BuildingConstruction deleteBuildingConstructionById(Long buildingConstructionId);
}
