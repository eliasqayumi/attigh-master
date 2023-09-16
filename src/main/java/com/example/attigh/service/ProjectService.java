package com.example.attigh.service;

import com.example.attigh.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project insert(Project project);

    Project update(Long projectId, Project project);

    Project findById(Long projectId);

    Project deleteProjectById(Long projectId);
}