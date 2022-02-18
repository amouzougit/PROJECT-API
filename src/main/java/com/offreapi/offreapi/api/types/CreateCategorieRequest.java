package com.offreapi.offreapi.api.types;

import javax.validation.constraints.NotBlank;

public class CreateCategorieRequest {
	
	 @NotBlank
	private String titre;
	 
	 @NotBlank
	private String description;

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
	 
	 

}
