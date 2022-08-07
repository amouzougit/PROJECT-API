package com.offreapi.offreapi.api.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post {
	
		@Id
		private String id;
		private String idUser;
		private String idCategorie = null;
		private String description;
		private String titre;
		private Date createDate;
		private Date modifiedDate;
		private List <Demande> demandes;
		
		public Post() {	
		}

		
		public Post(String idUser,String description, String titre) {
			super();
			this.idUser = idUser;
			this.description = description;
			this.titre = titre;
			this.createDate = new Date();
		}
			
		
		public Post(String id,String idUser,  String idCategorie, String description, Date createDate, Date modifiedDate) {
			super();
			this.idUser = idUser;
			this.id = id;
			this.description = description;
			this.createDate = createDate;
			this.modifiedDate = modifiedDate;
		}

		public String getIdUser() {
			return idUser;
		}

		public void setIdUser(String idUser) {
			this.idUser = idUser;
		}

		public List<Demande> getDemandes() {
			return demandes;
		}


		public void setDemandes(List<Demande> demandes) {
			this.demandes = demandes;
		}


		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIdCategorie() {
			return idCategorie;
		}

		public void setIdCategorie(String idCategorie) {
			this.idCategorie = idCategorie;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public String getTitre() {
			return titre;
		}


		public void setTitre(String titre) {
			this.titre = titre;
		}


		@Override
		public String toString() {
			return "Post [idPost=" + idUser + ", id=" + id + ", idCategorie=" + idCategorie + ", description=" + description
					+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
		}
		
		
		

}
