package com.offreapi.offreapi.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "profession")
public class Profession {
	
	@Id
	private String id;
	
	public Profession() {
		
	}


	
	

}
