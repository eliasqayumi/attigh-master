package com.example.attigh.repo;

import com.example.attigh.model.Etude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudeRepository extends JpaRepository<Etude, Long> {
    List<Etude> findAllByProject_id(Long projectId);
}
