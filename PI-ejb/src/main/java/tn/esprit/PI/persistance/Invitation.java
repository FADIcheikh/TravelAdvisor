package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the invitations database table.
 * 
 */
@Entity
@Table(name="invitations")
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvitationPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Lob
	private String invitationState;

	@Lob
	private String nomSender;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserFK")
	private User user;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="EventFK")
	private Event event;

	public Invitation() {
	}

	public InvitationPK getId() {
		return this.id;
	}

	public void setId(InvitationPK id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInvitationState() {
		return this.invitationState;
	}

	public void setInvitationState(String invitationState) {
		this.invitationState = invitationState;
	}

	public String getNomSender() {
		return this.nomSender;
	}

	public void setNomSender(String nomSender) {
		this.nomSender = nomSender;
	}

	public User getAspnetuser() {
		return this.user;
	}

	public void setAspnetuser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}