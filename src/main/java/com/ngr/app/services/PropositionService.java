package com.ngr.app.services;

import java.util.List;

import com.ngr.app.entity.Proposition;

public interface PropositionService {
    Proposition createProposition(Proposition proposition);
    List<Proposition> getPendingPropositions();
    Proposition approveProposition(Integer propositionId);
    Proposition rejectProposition(Integer propositionId);
}
