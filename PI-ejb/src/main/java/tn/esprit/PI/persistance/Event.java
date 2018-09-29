package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEvent;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDateEvent;

	@Lob
	private String imageUrl;

	@Lob
	private String nameEvent;

	private double priceEvent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDateEvent;

	@OneToMany(mappedBy="event")
	private List<Commentaire> commentaires;
	
	//bi-directional many-to-one association to Touristicplace
	@ManyToOne
	@JoinColumn(name="TouristicPlacesId")
	private Touristicplace touristicplace;

	//bi-directional many-to-one association to Invitation
	@OneToMany(mappedBy="event")
	private List<Invitation> invitations;
	
	@ManyToOne
	private User user;
	public Event() {
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDateEvent() {
		return this.endDateEvent;
	}

	public void setEndDateEvent(Date endDateEvent) {
		this.endDateEvent = endDateEvent;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getNameEvent() {
		return this.nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public double getPriceEvent() {
		return this.priceEvent;
	}

	public void setPriceEvent(double priceEvent) {
		this.priceEvent = priceEvent;
	}

	public Date getStartDateEvent() {
		return this.startDateEvent;
	}

	public void setStartDateEvent(Date startDateEvent) {
		this.startDateEvent = startDateEvent;
	}

	public Touristicplace getTouristicplace() {
		return this.touristicplace;
	}

	public void setTouristicplace(Touristicplace touristicplace) {
		this.touristicplace = touristicplace;
	}

	public List<Invitation> getInvitations() {
		return this.invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public Invitation addInvitation(Invitation invitation) {
		getInvitations().add(invitation);
		invitation.setEvent(this);

		return invitation;
	}

	public Invitation removeInvitation(Invitation invitation) {
		getInvitations().remove(invitation);
		invitation.setEvent(null);

		return invitation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}