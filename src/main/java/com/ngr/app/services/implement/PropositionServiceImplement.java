package com.ngr.app.services.implement;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngr.app.entity.Project;
import com.ngr.app.entity.Proposition;
import com.ngr.app.entity.PropositionStatus;
import com.ngr.app.repostories.PropositionRepository;
import com.ngr.app.services.ProjectService;
import com.ngr.app.services.PropositionService;

@Service
public class PropositionServiceImplement implements PropositionService {

    @Autowired
    private PropositionRepository propositionRepository;

    @Autowired
    private ProjectService projectService;
    

    @Override
    public Proposition createProposition(Proposition proposition) {
        proposition.setStatus(PropositionStatus.PENDING);
        proposition.setCreatedAt(LocalDateTime.now());
        return propositionRepository.save(proposition);
    }

    @Override
    public List<Proposition> getPendingPropositions() {
        return propositionRepository.findByStatus(PropositionStatus.PENDING);
    }

    @Override
    public Proposition approveProposition(Integer propositionId) {
        Proposition proposition = propositionRepository.findById(propositionId)
                .orElseThrow(() -> new RuntimeException("Proposition not found"));
        proposition.setStatus(PropositionStatus.APPROVED);
        propositionRepository.save(proposition);

        // Automatically create the project
        Project project = new Project();
        project.setName(proposition.getName());
        project.setShortName(proposition.getShortName());
        project.setType(proposition.getType());
        project.setTheme(proposition.getTheme());
        project.setVisibility(proposition.getVisibility());
        project.setLicenseName(proposition.getLicenseName());
        projectService.createProject(project);

        return proposition;
    }

    @Override
    public Proposition rejectProposition(Integer propositionId) {
        Proposition proposition = propositionRepository.findById(propositionId)
                .orElseThrow(() -> new RuntimeException("Proposition not found"));
        proposition.setStatus(PropositionStatus.REJECTED);
        return propositionRepository.save(proposition);
    }
}
