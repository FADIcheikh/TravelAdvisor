package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommentairePK
 *
 */
@Embeddable
public class CommentairePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dateCommentaire;

	@Column(insertable=false, updatable=false)
	private int idEvent;

	@Column(insertable=false, updatable=false)
	private int idSimpleUser;

	public CommentairePK() {
	}
	public CommentairePK(int idEvent) {
		
		this.idEvent=idEvent;
		
		}
	
	public CommentairePK(int idSimpleUser,int idEvent) {
	this.idSimpleUser=idSimpleUser;
	this.idEvent=idEvent;
	
	}
	
	public CommentairePK(int idSimpleUser,int idEvent,Date dateCommentaire) {
	this.idSimpleUser=idSimpleUser;
	this.idEvent=idEvent;
	this.dateCommentaire=dateCommentaire;
	}
	
	public java.util.Date getDateCommentaire() {
		return this.dateCommentaire;
	}
	public void setDateCommentaire(java.util.Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public int getIdEvent() {
		return this.idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}


	public int getIdSimpleUser() {
		return idSimpleUser;
	}
	public void setIdSimpleUser(int idSimpleUser) {
		this.idSimpleUser = idSimpleUser;
	}
	
	@Override
	public String toString() {
		return "CommentairePK [dateCommentaire=" + dateCommentaire + ", idEvent=" + idEvent + ", idSimpleUser="
				+ idSimpleUser + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCommentaire == null) ? 0 : dateCommentaire.hashCode());
		result = prime * result + idEvent;
		result = prime * result + idSimpleUser;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentairePK other = (CommentairePK) obj;
		if (dateCommentaire == null) {
			if (other.dateCommentaire != null)
				return false;
		} else if (!dateCommentaire.equals(other.dateCommentaire))
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idSimpleUser != other.idSimpleUser)
			return false;
		return true;
	}
	
	
}
