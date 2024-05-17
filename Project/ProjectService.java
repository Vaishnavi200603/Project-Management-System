package com.example.ProjectManagementSystem.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();
    void createProject(Project project);
    Project getProjectById(Long id);
    boolean deleteProjectById(Long id);
    boolean updateProjectById(Long id, Project updateProject);
}
