package com.offreapi.offreapi.api.types;

import org.springframework.data.annotation.Id;

public class CreateConfigurationRequest {
	
	@Id
	private String id;
	
	public CreateConfigurationRequest(String id) {
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
