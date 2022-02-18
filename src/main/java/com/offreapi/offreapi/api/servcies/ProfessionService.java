package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Profession;

public interface ProfessionService {
	

	 public void createProfession(List<Profession> profess);


	    public Collection<Profession> getAllProfessions();


	    public Optional<Profession> findProfessionById(int id);


	    public void deleteProfessionById(int id);


	    public void updateProfession(Profession profession);


	    public void deleteAllProfessions();


}
