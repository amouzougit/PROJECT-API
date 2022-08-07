package com.offreapi.offreapi.api.types;

import javax.validation.constraints.NotBlank;

public class CreateUserRequest {
	

	@NotBlank
    private String username;

	@NotBlank
    private String email;
    
    private  String telephone;
    
    private  String profession;
    @NotBlank
    private  String password;
    

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
    
}
