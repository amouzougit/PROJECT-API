package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Demande;

public interface DemandeService {
	

	public void createDemande(List< Demande> demande);


    public Collection<Demande> getAllDemandes();


    public Optional<Demande> findDemandeById(int id);


    public void deleteDemandeById(int id);


    public void updateDemande(Demande demande);


    public void deleteAllDemandes();

}
