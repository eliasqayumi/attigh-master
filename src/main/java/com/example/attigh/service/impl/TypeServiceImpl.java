package com.example.attigh.service.impl;

import com.example.attigh.model.Type;
import com.example.attigh.repo.TypeRepository;
import com.example.attigh.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    @Override
    public List<Type> getAll() {
        return this.typeRepository.findAll();
    }

    @Override
    public Type insert(Type type) {
        return this.typeRepository.save(type);
    }

    @Override
    public Type update(Integer typeId, Type type) {
        Type modifyType = this.findById(typeId);
        modifyType.setProjectType(type.getProjectType());
        return this.typeRepository.save(modifyType);
    }

    @Override
    public Type findById(Integer typeId) {
        return this.typeRepository.findById(typeId).orElseThrow();
    }

    @Override
    public Type deleteTypeById(Integer typeId) {
        Type deleteType = this.findById(typeId);
        this.typeRepository.deleteById(typeId);
        return deleteType;
    }

}
