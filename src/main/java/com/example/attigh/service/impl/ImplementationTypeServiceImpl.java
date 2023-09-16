package com.example.attigh.service.impl;

import com.example.attigh.model.ImplementationType;
import com.example.attigh.repo.ImplementationTypeRepository;
import com.example.attigh.service.ImplementationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ImplementationTypeServiceImpl implements ImplementationTypeService {
    private final ImplementationTypeRepository implementationTypeRepository;
    @Override
    public List<ImplementationType> getAll() {
        return this.implementationTypeRepository.findAll();
    }

    @Override
    public ImplementationType insert(ImplementationType implementationType) {
        return this.implementationTypeRepository.save(implementationType);
    }

    @Override
    public ImplementationType update(Integer implementationTypeId, ImplementationType implementationType) {
        ImplementationType modifyImplementationType = this.findById(implementationTypeId);
        modifyImplementationType.setImplementationType(implementationType.getImplementationType());
        return this.implementationTypeRepository.save(modifyImplementationType);
    }

    @Override
    public ImplementationType findById(Integer implementationTypeId) {
        return this.implementationTypeRepository.findById(implementationTypeId).orElseThrow();
    }

    @Override
    public ImplementationType deleteImplementationTypeById(Integer implementationTypeId) {
        ImplementationType deleteImplementationType = this.findById(implementationTypeId);
        this.implementationTypeRepository.deleteById(implementationTypeId);
        return deleteImplementationType;
    }

}
