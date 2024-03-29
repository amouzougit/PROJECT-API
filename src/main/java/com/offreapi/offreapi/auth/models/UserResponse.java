package com.offreapi.offreapi.auth.models;


import org.springframework.data.annotation.Id;

import com.sun.mail.handlers.text_html;

public class UserResponse {
	 @Id
    private String id;

    private String username;

    private String email;
    
    private String telephone;
    
    private String profession;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
