package com.ngr.app.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.ngr.app.repostories.RoleRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RolePerGroup {
	

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesPerGroup role;

    // Constructors, Getters, Setters
    public RolePerGroup() {}

    public RolePerGroup(RolesPerGroup role) {
        this.role= role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return role.toString();
    }

    public void setName(RolesPerGroup role) {
        this.role = role;
    }
    
    
//    @PostConstruct
//    public void init() {
//        if (repo.count() == 0) { 
//            for (Roles roleType : Roles.values()) {
//                Role role = new Role(roleType);
//                repo.save(role);
//            }
//        }
//    }
   
//    @Autowired
//    private RoleRepository roleRepository;
//	
    
    
    
}
