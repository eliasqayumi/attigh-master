package com.example.attigh.service.impl;

import com.example.attigh.model.Project;
import com.example.attigh.repo.ProjectRepository;
import com.example.attigh.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    @Override
    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project insert(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public Project update(Long projectId, Project project) {
        Project modifyProject = this.findById(projectId);
        modifyProject.setProjectCode(project.getProjectCode());
        modifyProject.setProjectName(project.getProjectName());
        modifyProject.setType(project.getType());
        modifyProject.setImplementationType(project.getImplementationType());
        return this.projectRepository.save(modifyProject);
    }

    @Override
    public Project findById(Long projectId) {
        return this.projectRepository.findById(projectId).orElseThrow();
    }

    @Override
    public Project deleteProjectById(Long projectId) {
        Project deleteProject = this.findById(projectId);
        this.projectRepository.deleteById(projectId);
        return deleteProject;
    }

}
