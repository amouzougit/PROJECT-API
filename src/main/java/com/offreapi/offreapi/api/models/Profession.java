package com.offreapi.offreapi.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "profession")
public class Profession {
	
	@Id
	private String id;
	
	private String libelle;
	
	private String code;

	
	public Profession() {
		
	}


	public Profession(String id, String libelle, String code) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	
	

	
	

}
