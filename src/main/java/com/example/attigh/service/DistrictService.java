package com.example.attigh.service;

import com.example.attigh.model.District;

import java.util.List;

public interface DistrictService {
    List<District> getAll();

    District insert(District district);

    District update(Long districtId, District district);

    District findById(Long districtId);

    District deleteDistrictById(Long districtId);
}