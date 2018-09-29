package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity
@Table(name="commentaires")
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommentairePK id;

	private String commentaire;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idSimpleUser", updatable=false, insertable=false)
	private User User;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="idEvent", insertable=false, updatable=false)
	private Event event;
	
	//bi-directional many-to-one association to ReclamationComEvent
		@OneToMany(mappedBy="comevent",cascade=CascadeType.ALL)
		private List<ReclamationComEvent> reclamationcomevent;
		
	
		

	public Commentaire() {
	}

	public Commentaire(CommentairePK id) {
		this.id=id;
	}
	public CommentairePK getId() {
		return this.id;
	}

	public void setId(CommentairePK id) {
		this.id = id;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", commentaire=" + commentaire + ", User=" + User + ", event="
				+ event + "]";
	}

	public List<ReclamationComEvent> getReclamationcomevent() {
		return reclamationcomevent;
	}

	public void setReclamationcomevent(List<ReclamationComEvent> reclamationcomevent) {
		this.reclamationcomevent = reclamationcomevent;
	}
	
	

}