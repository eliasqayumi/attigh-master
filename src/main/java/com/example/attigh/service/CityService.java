package com.example.attigh.service;

import com.example.attigh.model.City;

import java.util.List;

public interface CityService {
    List<City> getAll();

    City insert(City city);

    City update(Integer cityId, City city);

    City findById(Integer cityId);

    City deleteCityById(Integer cityId);
}
