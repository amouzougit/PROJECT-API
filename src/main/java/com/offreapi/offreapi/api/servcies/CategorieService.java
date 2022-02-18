package com.offreapi.offreapi.api.servcies;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.offreapi.offreapi.api.models.Categorie;

public interface CategorieService {
	

	public void createCategorie(List<Categorie> categorie);


    public Collection<Categorie> getAllCategories();


    public Optional<Categorie> findCategorieById(String id);


    public void deleteCategorieById(int id);


    public void updateCategorie(Categorie categorie);


    public void deleteAllCategories();

}
