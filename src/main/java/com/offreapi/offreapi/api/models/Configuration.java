package com.offreapi.offreapi.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "configuration")
public class Configuration {
	
	@Id
	private String id;
	
	public Configuration() {
		
	}

	public Configuration(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setIdConfig(String id) {
		this.id = id;
	}
	
	

}
