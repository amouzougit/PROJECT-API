package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Proposition;

public interface PropositionService {
	
	public void createProposition(List<Proposition> proposition);


    public Collection<Proposition> getAllPropositions();


    public Optional<Proposition> findPropositionById(int idPropos);


    public void deletePropositionById(int idPropos);


    public void updateProposition(Proposition proposition);


    public void deleteAllPropositions();


}
