package com.example.attigh.repo;

import com.example.attigh.model.ImplementationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplementationTypeRepository extends JpaRepository<ImplementationType,Integer> {
}
