package com.offreapi.offreapi.api.types;

import javax.validation.constraints.NotBlank;

public class UpdatePostRequest {

	
	@NotBlank
    private String id;
	
	@NotBlank
    private String titre;

	@NotBlank
    private String description;
    
    private  String idCategorie;

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

	public String getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
