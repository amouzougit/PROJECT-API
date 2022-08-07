package com.offreapi.offreapi.api.types;

import javax.validation.constraints.NotBlank;


public class CreateDemandeRequest {
	
	 @NotBlank
	private String idPost;
	 
	 @NotBlank
	private String description;
	 
	 @NotBlank
		private String telephone;
	 
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	 
	 

}
