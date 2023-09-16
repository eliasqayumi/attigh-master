package com.example.attigh.service.impl;

import com.example.attigh.model.BuildingConstruction;
import com.example.attigh.repo.BuildingConstructionRepository;
import com.example.attigh.service.BuildingConstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuildingConstructionServiceImpl implements BuildingConstructionService {

    private final BuildingConstructionRepository buildingConstructionRepository;
    @Override
    public List<BuildingConstruction> getAll() {
        return this.buildingConstructionRepository.findAll();
    }

    @Override
    public BuildingConstruction insert(BuildingConstruction district) {
        return this.buildingConstructionRepository.save(district);
    }

    @Override
    public BuildingConstruction update(Long buildingConstructionId, BuildingConstruction buildingConstruction) {
        BuildingConstruction modifyBuildingConstruction = this.findById(buildingConstructionId);

        modifyBuildingConstruction.setRegisteredArea(buildingConstruction.getRegisteredArea());
        modifyBuildingConstruction.setWay(buildingConstruction.getWay());
        modifyBuildingConstruction.setStabilized(buildingConstruction.getStabilized());
        modifyBuildingConstruction.setDrainage(buildingConstruction.getDrainage());
        modifyBuildingConstruction.setDraft(buildingConstruction.getDraft());
        modifyBuildingConstruction.setLeveling(buildingConstruction.getLeveling());
        modifyBuildingConstruction.setNewParcelNumber(buildingConstruction.getNewParcelNumber());
        modifyBuildingConstruction.setConsolidationRate(buildingConstruction.getConsolidationRate());
        modifyBuildingConstruction.setBusinessParcelNumberNew(buildingConstruction.getBusinessParcelNumberNew());
        modifyBuildingConstruction.setBusinessParcelNumberOld(buildingConstruction.getBusinessParcelNumberOld());
        modifyBuildingConstruction.setParcelAverageAreaOld(buildingConstruction.getParcelAverageAreaOld());
        modifyBuildingConstruction.setOtkpRatio(buildingConstruction.getOtkpRatio());
        modifyBuildingConstruction.setCost(buildingConstruction.getCost());
        modifyBuildingConstruction.setRegistrationDate(buildingConstruction.getRegistrationDate());

        return this.buildingConstructionRepository.save(modifyBuildingConstruction);
    }

    @Override
    public BuildingConstruction findById(Long buildingConstructionId) {
        return this.buildingConstructionRepository.findById(buildingConstructionId).orElseThrow();
    }

    @Override
    public BuildingConstruction deleteBuildingConstructionById(Long buildingConstructionId) {
        BuildingConstruction deleteBuildingConstructionId = this.findById(buildingConstructionId);
        this.buildingConstructionRepository.deleteById(buildingConstructionId);
        return deleteBuildingConstructionId;
    }
}
