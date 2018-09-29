package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Experience
 *
 */
@Entity

public class Experience implements Serializable {

	@EmbeddedId
	private ExperiencePK id;
	private String description;
	private String nom;
	private String type;
	private int note;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="TPFK",referencedColumnName="idTouristicPlaces",insertable=false,updatable=false)
	private Touristicplace touristicplace;
	@ManyToOne
	@JoinColumn(name="userPK",referencedColumnName="id",insertable=false,updatable=false)
	private User user;
	
	//bi-directional many-to-one association to Imageexperience
	@OneToMany(mappedBy="experience")
	private List<Imageexperience> imageexperiences;
	public Experience() {
		super();
	}
	public ExperiencePK getId() {
		return id;
	}
	public void setId(ExperiencePK id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Touristicplace getTouristicplace() {
		return touristicplace;
	}
	public void setTouristicplace(Touristicplace touristicplace) {
		this.touristicplace = touristicplace;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Imageexperience> getImageexperiences() {
		return imageexperiences;
	}
	public void setImageexperiences(List<Imageexperience> imageexperiences) {
		this.imageexperiences = imageexperiences;
	}   
	
}