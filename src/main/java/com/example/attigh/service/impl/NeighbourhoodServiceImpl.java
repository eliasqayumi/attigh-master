package com.example.attigh.service.impl;


import com.example.attigh.model.Neighbourhood;
import com.example.attigh.repo.NeighbourhoodRepository;
import com.example.attigh.service.NeighbourhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NeighbourhoodServiceImpl implements NeighbourhoodService {

    private final NeighbourhoodRepository neighbourhoodRepository;
    @Override
    public List<Neighbourhood> getAll() {
        return this.neighbourhoodRepository.findAll();
    }

    @Override
    public Neighbourhood insert(Neighbourhood neighbourhood) {
        return this.neighbourhoodRepository.save(neighbourhood);
    }

    @Override
    public Neighbourhood update(Long neighbourhoodId, Neighbourhood neighbourhood) {
        Neighbourhood modifyNeighbourhood = this.findById(neighbourhoodId);
        modifyNeighbourhood.setNeighbourhoodName(neighbourhood.getNeighbourhoodName());
        return this.neighbourhoodRepository.save(modifyNeighbourhood);
    }

    @Override
    public Neighbourhood findById(Long neighbourhoodId) {
        return this.neighbourhoodRepository.findById(neighbourhoodId).orElseThrow();
    }

    @Override
    public Neighbourhood deleteNeighbourhoodById(Long neighbourhoodId) {
        Neighbourhood deleteNeighbourhood = this.findById(neighbourhoodId);
        this.neighbourhoodRepository.deleteById(neighbourhoodId);
        return deleteNeighbourhood;
    }
}
