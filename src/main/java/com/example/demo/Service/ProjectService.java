package com.example.demo.Service;

import com.example.demo.Model.Project;
import com.example.demo.Model.ProjectPage;
import com.example.demo.Repo.ProjectRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Page<Project> getProjects(ProjectPage projectPage){
        Sort sort = Sort.by(
                projectPage.getSortDirection(),
                projectPage.getSortBy()
        );
        Pageable paging = PageRequest.of(
                projectPage.getPageNumber(),
                projectPage.getPageSize(),
                sort
        );
        return projectRepo.findAll(paging);
    }
    public Project addNewProject(Project project){
        return projectRepo.save(project);
    }
}
