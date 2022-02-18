package com.offreapi.offreapi.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categorie")
public class Categorie {
	
	
	@Id
	private String id;
	private String titre;
	private String description;
	
	public Categorie() {
		
	}

	
	public Categorie( String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}
	
	
	public Categorie(String id, String titre, String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + id + ", titre=" + titre + ", description=" + description + "]";
	}
	
	

}
