package com.ngr.app.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngr.app.entity.Role;
import com.ngr.app.entity.RolePerGroup;
import com.ngr.app.entity.Roles;
import com.ngr.app.entity.RolesPerGroup;
import com.ngr.app.repostories.RolePerGroupRepository;
import com.ngr.app.repostories.RoleRepository;

import jakarta.annotation.PostConstruct;

@Service
public class RolePerGroupInitializer {

    @Autowired
    private RolePerGroupRepository rolePerGroupRepository;

    @PostConstruct
    public void initRoles() {
        if (rolePerGroupRepository.count() == 0) {
            for (RolesPerGroup roleType : RolesPerGroup.values()) {
                RolePerGroup role = new RolePerGroup(roleType);
                rolePerGroupRepository.save(role);
            }
        }
    }
}