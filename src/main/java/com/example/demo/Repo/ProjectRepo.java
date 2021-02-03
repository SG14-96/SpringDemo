package com.example.demo.Repo;

import com.example.demo.Model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends PagingAndSortingRepository<Project,Long> {
}
