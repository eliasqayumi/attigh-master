package com.example.attigh.service;

import com.example.attigh.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> getAll();

    Type insert(Type type);

    Type update(Integer typeId, Type type);

    Type findById(Integer typeId);

    Type deleteTypeById(Integer typeId);
}
