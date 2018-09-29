package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FriendsInvitation
 *
 */
@Entity

public class FriendsInvitation implements Serializable {

	   
	@Id
	private int idInvitation;
	private boolean state;
	private Date date;
	@ManyToOne
	private User userSender;
	@ManyToOne
	private User userReceiver;
	private static final long serialVersionUID = 1L;

	public FriendsInvitation() {
		super();
	}   
	public int getIdInvitation() {
		return this.idInvitation;
	}

	public void setIdInvitation(int idInvitation) {
		this.idInvitation = idInvitation;
	}   
	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUserSender() {
		return userSender;
	}
	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}
	public User getUserReceiver() {
		return userReceiver;
	}
	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}
   
}
