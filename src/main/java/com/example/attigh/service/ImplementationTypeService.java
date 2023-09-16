package com.example.attigh.service;

import com.example.attigh.model.ImplementationType;

import java.util.List;

public interface ImplementationTypeService {
    List<ImplementationType> getAll();

    ImplementationType insert(ImplementationType implementationType);

    ImplementationType update(Integer implementationTypeId, ImplementationType implementationType);

    ImplementationType findById(Integer implementationTypeId);

    ImplementationType deleteImplementationTypeById(Integer implementationTypeId);
}
