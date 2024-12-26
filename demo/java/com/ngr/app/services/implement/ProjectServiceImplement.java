package com.ngr.app.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngr.app.entity.Group;
import com.ngr.app.entity.Project;
import com.ngr.app.repostories.GroupRepository;
import com.ngr.app.repostories.ProjectRepository;
import com.ngr.app.services.ProjectService;

@Service
public class ProjectServiceImplement implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    
    @Autowired
    private GroupRepository groupRepository;

    public Project createProject(Project project) {
        Group projectGroup = new Group();
        projectGroup.setName(project.getName());
        groupRepository.save(projectGroup);

        Group adminGroup = new Group();
        adminGroup.setName(project.getName() + "-adm");
        groupRepository.save(adminGroup);

        project.setProjectGroup(projectGroup);
        project.setAdminGroup(adminGroup);

        return projectRepository.save(project);
    }
}
