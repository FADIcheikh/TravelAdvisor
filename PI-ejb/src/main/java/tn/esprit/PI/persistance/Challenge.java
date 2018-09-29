package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Challenge
 *
 */
@Entity

public class Challenge implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idChallenge;
	private String name;
	private String Description;
	private Date DateDebut;
	private Date DateFin;
	@OneToMany(mappedBy="challenge",cascade=CascadeType.ALL)
	private List<Note> ListNote;
	
	
	private static final long serialVersionUID = 1L;

	public Challenge() {
		super();
	}   
	public Integer getIdChallenge() {
		return this.idChallenge;
	}

	public void setIdChallenge(Integer idChallenge) {
		this.idChallenge = idChallenge;
	}   
	public String getName() {
		return this.name;
	}

	public Date getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public void setName(String name) {
		this.name = name;
	}   
 
	public List<Note> getListNote() {
		return ListNote;
	}
	public void setListNote(List<Note> listNote) {
		ListNote = listNote;
	}
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
   
}
