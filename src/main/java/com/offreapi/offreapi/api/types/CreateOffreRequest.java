package com.offreapi.offreapi.api.types;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class CreateOffreRequest {
	
 	 @NotBlank
 	 private String idCategorie;
 	 @NotBlank
 	 private String description;
 	 @NotBlank
 	 private String titre;
 	 @NotBlank
 	 private String contenu;

	public String getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
 	 
 	 



}
