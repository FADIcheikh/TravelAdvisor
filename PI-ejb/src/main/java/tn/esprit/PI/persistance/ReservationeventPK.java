package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReservationeventPK
 *
 */
@Embeddable
public class ReservationeventPK implements Serializable {

	@Column(name="id_User")
    private String userPK;
	@Column(name="id_event")
    private int eventPK;
	
	private static final long serialVersionUID = 1L;

	public ReservationeventPK() {
		super();
	}

	public String getUserPK() {
		return userPK;
	}

	public void setUserPK(String userPK) {
		this.userPK = userPK;
	}

	public int getEventPK() {
		return eventPK;
	}

	public void setEventPK(int eventPK) {
		this.eventPK = eventPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventPK;
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
		ReservationeventPK other = (ReservationeventPK) obj;
		if (eventPK != other.eventPK)
			return false;
		if (userPK == null) {
			if (other.userPK != null)
				return false;
		} else if (!userPK.equals(other.userPK))
			return false;
		return true;
	}
	
	
   
}
