package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationofferPK
 *
 */
@Embeddable
public class ReservationofferPK implements Serializable {

	@Column(name="id_User")
    private String userPK;
	@Column(name="id_offer")
    private int offerPK;
	private static final long serialVersionUID = 1L;

	public ReservationofferPK() {
		super();
	}

	public String getUserPK() {
		return userPK;
	}

	public void setUserPK(String userPK) {
		this.userPK = userPK;
	}

	public int getOfferPK() {
		return offerPK;
	}

	public void setOfferPK(int offerPK) {
		this.offerPK = offerPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offerPK;
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
		ReservationofferPK other = (ReservationofferPK) obj;
		if (offerPK != other.offerPK)
			return false;
		if (userPK == null) {
			if (other.userPK != null)
				return false;
		} else if (!userPK.equals(other.userPK))
			return false;
		return true;
	}
	
	
   
}
