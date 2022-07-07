package com.offreapi.offreapi.auth.playload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class VerifyForgotPasswordResquest {

	@NotBlank
    private String code;

    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String newPassword ;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
    
    
	
}
