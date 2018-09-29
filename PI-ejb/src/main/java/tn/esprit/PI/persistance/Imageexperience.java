package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imageexperiences database table.
 * 
 */
@Entity
@Table(name="imageexperiences")
@NamedQuery(name="Imageexperience.findAll", query="SELECT i FROM Imageexperience i")
public class Imageexperience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idImageExperience;

	@Lob
	private String nom;

	//bi-directional many-to-one association to Experience
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="experience_Date", referencedColumnName="Date"),
		@JoinColumn(name="experience_TPFK", referencedColumnName="TPFK"),
		@JoinColumn(name="experience_UserPK", referencedColumnName="UserPK")
		})
	private Experience experience;

	public Imageexperience() {
	}

	public int getIdImageExperience() {
		return this.idImageExperience;
	}

	public void setIdImageExperience(int idImageExperience) {
		this.idImageExperience = idImageExperience;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Experience getExperience() {
		return this.experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

}