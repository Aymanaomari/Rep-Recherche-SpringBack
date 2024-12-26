package com.ngr.app.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngr.app.entity.Role;
import com.ngr.app.entity.Roles;
import com.ngr.app.repostories.RoleRepository;

import jakarta.annotation.PostConstruct;

@Service
public class RoleInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initRoles() {
        if (roleRepository.count() == 0) {
            for (Roles roleType : Roles.values()) {
                Role role = new Role(roleType);
                roleRepository.save(role);
            }
        }
    }
}