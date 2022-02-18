package com.offreapi.offreapi.api.types;

import javax.validation.constraints.NotBlank;


public class CreateDemandeRequest {
	

	
	 @NotBlank
	private String idCategorie;
	 
	 @NotBlank
	private String description;
	 
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
	 
	 

}
