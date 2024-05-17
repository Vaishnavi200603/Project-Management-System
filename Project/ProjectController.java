package com.example.ProjectManagementSystem.Project;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projects")
@ControllerAdvice
public class ProjectController {
    private ProjectService projectService;

    //as we define it's object interface as a service class - springBoot
    //will take care that projectService Object being available at the run
    //time and it will get initialize over the RestController Annotation
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        try{
            return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<String> createProject(@Valid @RequestBody Project addProjects){
        projectService.createProject(addProjects);
        return new ResponseEntity<>("Your Project Details Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        try{
            Project project = projectService.getProjectById(id);
            if(project != null) return new ResponseEntity<>(project, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id) {
        try {
            boolean isDeleted = projectService.deleteProjectById(id);
            if (isDeleted) return new ResponseEntity<>("Project Details Deleted Successfully", HttpStatus.OK);
            else return new ResponseEntity<>("Id Not Available, Try Again", HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectDetailById(@PathVariable Long id,
                                                           @Valid @RequestBody Project updateProject){
        boolean isUpdated = projectService.updateProjectById(id, updateProject);
        if(isUpdated) return new ResponseEntity<>(updateProject, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
