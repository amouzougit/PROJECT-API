package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Offre;

public interface OffreService {
	
	public void createOffre(List<Offre> offre);


    public Collection<Offre> getAllOffres();


    public Optional<Offre> findOffreById(int id);


    public void deleteOffreById(int id);


    public void updateOffre(Offre offre);


    public void deleteAllOffres();

}
