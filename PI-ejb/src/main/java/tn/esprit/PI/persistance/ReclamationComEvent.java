package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reccomevent")
public class ReclamationComEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Objet;
	private String contenue;
	private Date datereclamation;
	private boolean etat=false;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Commentaire comevent;
	
	
	
	public ReclamationComEvent() {
		super();
	}
	public ReclamationComEvent(Integer id, String objet, String contenue,Date datereclamation,boolean etat) {
		super();
		this.id = id;
		Objet = objet;
		this.contenue = contenue;
		this.datereclamation=datereclamation;
		this.setEtat(etat);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjet() {
		return Objet;
	}
	public void setObjet(String objet) {
		Objet = objet;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	public Commentaire getComevent() {
		return comevent;
	}
	public void setComevent(Commentaire comevent) {
		this.comevent = comevent;
	}
	public Date getDatereclamation() {
		return datereclamation;
	}
	public void setDatereclamation(Date datereclamation) {
		this.datereclamation = datereclamation;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
}
