package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Note
 *
 */
@Entity

public class Note implements Serializable {
    @EmbeddedId
	private NotePK notePK;
	private Integer note;
	@ManyToOne
	@JoinColumn(name="id_Challenge",referencedColumnName="idChallenge",insertable=false,updatable=false)
	private Challenge challenge;
	@ManyToOne
	@JoinColumn(name="id_User",referencedColumnName="id",insertable=false,updatable=false)
	private User user;
	
	private static final long serialVersionUID = 1L;

	public Note() {
		super();
	}   
	
	
	public Challenge getChallenge() {
		return challenge;
	}


	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public NotePK getNotePK() {
		return notePK;
	}

	public void setNotePK(NotePK notePK) {
		this.notePK = notePK;
	}

	public Integer getNote() {
		return this.note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
   
}
