package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExperiencePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="userPK")
    private String userPK;
	@Column(name="TPFK")
    private int TPFK;
	private Date date;
	public String getUserPK() {
		return userPK;
	}
	public void setUserPK(String userPK) {
		this.userPK = userPK;
	}
	public int getTPFK() {
		return TPFK;
	}
	public void setTPFK(int tPFK) {
		TPFK = tPFK;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TPFK;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((userPK == null) ? 0 : userPK.hashCode());
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
		ExperiencePK other = (ExperiencePK) obj;
		if (TPFK != other.TPFK)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (userPK == null) {
			if (other.userPK != null)
				return false;
		} else if (!userPK.equals(other.userPK))
			return false;
		return true;
	}

}
