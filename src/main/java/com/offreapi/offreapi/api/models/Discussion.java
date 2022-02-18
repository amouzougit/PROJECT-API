package com.offreapi.offreapi.api.models;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collation = "discussion")
public class Discussion {

	@Id

	private String id;
	
	private Date createDate;

	private Date modifiedDate;
	
	public Discussion() {
		
	}

	
	public Discussion(String id) {
		
	}

	
	public Discussion(String id, Date createDate, Date modifiedDate) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}

	public String getIdDisscussion() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Discussion [idDisscussion=" + id + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + "]";
	}
	
	
	

}
