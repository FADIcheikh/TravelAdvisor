package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: NotePK
 *
 */

@Embeddable
public class NotePK implements Serializable {
	@Column(name="id_User")
    private int userPK;
	@Column(name="id_Challenge")
    private int challengePK;
	
	private static final long serialVersionUID = 1L;

	public NotePK() {
		super();
	}

	



	public int getUserPK() {
		return userPK;
	}





	public void setUserPK(int userPK) {
		this.userPK = userPK;
	}





	public int getChallengePK() {
		return challengePK;
	}

	public void setChallengePK(int challengePK) {
		this.challengePK = challengePK;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + challengePK;
		result = prime * result + userPK;
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
		NotePK other = (NotePK) obj;
		if (challengePK != other.challengePK)
			return false;
		if (userPK != other.userPK)
			return false;
		return true;
	}
	
   
}
