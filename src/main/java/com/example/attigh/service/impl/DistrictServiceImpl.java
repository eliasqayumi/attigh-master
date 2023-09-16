package com.example.attigh.service.impl;

import com.example.attigh.model.District;
import com.example.attigh.repo.DistrictRepository;
import com.example.attigh.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    @Override
    public List<District> getAll() {
        return this.districtRepository.findAll();
    }

    @Override
    public District insert(District district) {
        return this.districtRepository.save(district);
    }

    @Override
    public District update(Long districtId, District district) {
        District modifyDistrict = this.findById(districtId);
        modifyDistrict.setDistrictName(district.getDistrictName());
        return this.districtRepository.save(modifyDistrict);
    }

    @Override
    public District findById(Long districtId) {
        return this.districtRepository.findById(districtId).orElseThrow();
    }

    @Override
    public District deleteDistrictById(Long districtId) {
        District deleteDistrict = this.findById(districtId);
        this.districtRepository.deleteById(districtId);
        return deleteDistrict;
    }

}
