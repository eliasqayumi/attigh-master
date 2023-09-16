package com.example.attigh.repo;

import com.example.attigh.model.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningRepository extends JpaRepository<Planning,Long> {

    List<Planning> findAllByProject_Id(Long projectId);
}
