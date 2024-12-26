package com.ngr.app.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngr.app.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
