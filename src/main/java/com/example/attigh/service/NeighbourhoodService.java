package com.example.attigh.service;

import com.example.attigh.model.Neighbourhood;

import java.util.List;

public interface NeighbourhoodService {

    List<Neighbourhood> getAll();

    Neighbourhood insert(Neighbourhood neighbourhood);

    Neighbourhood update(Long neighbourhoodId, Neighbourhood neighbourhood);

    Neighbourhood findById(Long neighbourhoodId);

    Neighbourhood deleteNeighbourhoodById(Long neighbourhoodId);
}
