package com.offreapi.offreapi.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "proposition")
public class Proposition {
	@Id
	private String id;
	
	public Proposition() {
		
	}

	public Proposition(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	


}
