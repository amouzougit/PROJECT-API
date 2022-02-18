package com.offreapi.offreapi.api.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "offre")
public class Offre extends Post{
	

	private String titre;
	//private Date createDate;
	//private Date modifiedDate;
	private String contenu;

	
	
	public Offre() {
		
	}

	public Offre(String idUser, String idCategorie, String description ,String contenu, String titre) {
		super(idUser, idCategorie, description);
		this.contenu = contenu;
		this.titre = titre;

	}
	

	public Offre(String idUser, String id, String idCategorie, String description, Date createDate, Date modifiedDate) {
		super(idUser, id, idCategorie, description, createDate, modifiedDate);
		// TODO Auto-generated constructor stub
	}


	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	


/*	public Date getCreateDate() {
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

*/

	public String getContenu() {
		return contenu;
	}



	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	@Override
	public String toString() {
		return "Offre [idOffre=" + ", titre=" + titre + ", description="  + ", createDate="
				+ ", modifiedDate="  + ", contenu=" + contenu + "]";
	}
	
	

}
