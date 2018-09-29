package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.util.Date;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity implementation class for Entity: Offer
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@NamedQuery(name = "Offer.findAll", query = "SELECT t FROM Offer t")
public class Offer implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdOffer;
	private String nameOffer;
	private String description;
	private Date startDateOffer;
	private Date endDateOffer;
	private Double priceOffer;
	@ManyToOne
	private Touristicplace touristicplace; 
	@ManyToOne
	private User user;
	
	private static final long serialVersionUID = 1L;

	public Offer() {
		super();
	}   
	@JsonCreator
	public Offer(@JsonProperty("nameOffer") String nameOffer) {
		this.nameOffer = nameOffer;
	}
	public int getIdOffer() {
		return this.IdOffer;
	}

	public void setIdOffer(int IdOffer) {
		this.IdOffer = IdOffer;
	}   
	public String getNameOffer() {
		return this.nameOffer;
	}

	public void setNameOffer(String nameOffer) {
		this.nameOffer = nameOffer;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getStartDateOffer() {
		return this.startDateOffer;
	}

	public void setStartDateOffer(Date startDateOffer) {
		this.startDateOffer = startDateOffer;
	}   
	public Date getEndDateOffer() {
		return this.endDateOffer;
	}

	public void setEndDateOffer(Date endDateOffer) {
		this.endDateOffer = endDateOffer;
	}   
	public Double getPriceOffer() {
		return this.priceOffer;
	}

	public void setPriceOffer(Double priceOffer) {
		this.priceOffer = priceOffer;
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
	@Override
	public String toString() {
		return "Offer [IdOffer=" + IdOffer + ", nameOffer=" + nameOffer + ", description=" + description
				+ ", priceOffer=" + priceOffer + "]";
	}
   
}
