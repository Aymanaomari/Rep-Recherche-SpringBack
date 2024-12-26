package com.ngr.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngr.app.entity.Proposition;
import com.ngr.app.services.PropositionService;

@RestController
@RequestMapping("/propositions")
public class PropositionController {

    @Autowired
    private PropositionService propositionService;

    @PostMapping
    public ResponseEntity<Proposition> submitProposition(@RequestBody Proposition proposition) {
        Proposition createdProposition = propositionService.createProposition(proposition);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProposition);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Proposition>> getPendingPropositions() {
        List<Proposition> pendingPropositions = propositionService.getPendingPropositions();
        return ResponseEntity.ok(pendingPropositions);
    }

    @PostMapping("/{propositionId}/approve")
    public ResponseEntity<Proposition> approveProposition(@PathVariable Integer propositionId) {
        Proposition approvedProposition = propositionService.approveProposition(propositionId);
        return ResponseEntity.ok(approvedProposition);
    }

    @PostMapping("/{propositionId}/reject")
    public ResponseEntity<Proposition> rejectProposition(@PathVariable Integer propositionId) {
        Proposition rejectedProposition = propositionService.rejectProposition(propositionId);
        return ResponseEntity.ok(rejectedProposition);
    }
}

