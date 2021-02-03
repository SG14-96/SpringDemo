package com.example.demo.Controller;

import com.example.demo.Model.Project;
import com.example.demo.Model.ProjectPage;
import com.example.demo.Service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Page<Project>> getProjects(ProjectPage projectPage){
        return new ResponseEntity<>(projectService.getProjects(projectPage), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return new ResponseEntity<>(projectService.addNewProject((project)),HttpStatus.OK);
    }
}
