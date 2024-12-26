package com.ngr.app.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngr.app.entity.Proposition;
import com.ngr.app.entity.PropositionStatus;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Integer> {
    List<Proposition> findByStatus(PropositionStatus status);
}
