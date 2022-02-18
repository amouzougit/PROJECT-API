package com.offreapi.offreapi.auth.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passwordResets")
public class PasswordReset {
	 @Id
	 private String id;
	 private String userId;
	 private String code;
	 private boolean isVerified;
	 private LocalDateTime createdAt;

	 private LocalDateTime isVerifiedAt;
	 
	 public PasswordReset(String code) {
		 this.code =code;
		 this.isVerified = false;
		 this.createdAt = LocalDateTime.now();
	 }
	 
	 
	 public PasswordReset() {
		 this.code =null;
		 this.isVerified = false;
		 this.createdAt = LocalDateTime.now();
	 }
	 
	 
	 public void reset() {
		 this.code = null;
		 this.isVerified = false;
		 this.isVerifiedAt = null;

	 }
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public LocalDateTime getIsVerifiedAt() {
		return isVerifiedAt;
	}

	public void setIsVerifiedAt(LocalDateTime isVerifiedAt) {
		this.isVerifiedAt = isVerifiedAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	
	
	

}
