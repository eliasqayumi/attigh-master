package com.example.attigh.repo;

import com.example.attigh.model.BuildingConstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingConstructionRepository extends JpaRepository<BuildingConstruction,Long> {
}
