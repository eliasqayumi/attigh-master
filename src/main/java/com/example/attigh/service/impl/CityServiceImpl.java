package com.example.attigh.service.impl;

import com.example.attigh.model.City;
import com.example.attigh.repo.CityRepository;
import com.example.attigh.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City insert(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public City update(Integer cityId, City city) {
        City modifyCity = this.findById(cityId);
        modifyCity.setCityCode(city.getCityCode());
        modifyCity.setCityName(city.getCityName());
        return this.cityRepository.save(modifyCity);
    }

    @Override
    public City findById(Integer cityId) {
        return this.cityRepository.findById(cityId).orElseThrow();
    }

    @Override
    public City deleteCityById(Integer cityId) {
        City deleteCity = this.findById(cityId);
        this.cityRepository.deleteById(cityId);
        return deleteCity;
    }

}
