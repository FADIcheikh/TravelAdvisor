package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the invitations database table.
 * 
 */
@Embeddable
public class InvitationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int eventFK;

	@Column(insertable=false, updatable=false)
	private String userFK;

	public InvitationPK() {
	}
	public int getEventFK() {
		return this.eventFK;
	}
	public void setEventFK(int eventFK) {
		this.eventFK = eventFK;
	}
	public String getUserFK() {
		return this.userFK;
	}
	public void setUserFK(String userFK) {
		this.userFK = userFK;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvitationPK)) {
			return false;
		}
		InvitationPK castOther = (InvitationPK)other;
		return 
			(this.eventFK == castOther.eventFK)
			&& this.userFK.equals(castOther.userFK);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eventFK;
		hash = hash * prime + this.userFK.hashCode();
		
		return hash;
	}
}