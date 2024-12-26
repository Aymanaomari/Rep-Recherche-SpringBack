package com.ngr.app.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngr.app.entity.RolePerGroup;
import com.ngr.app.entity.RolesPerGroup;

@Repository
public interface RolePerGroupRepository extends JpaRepository<RolePerGroup, Long> {
    Optional<RolePerGroup> findByRole(RolesPerGroup role);
}
