package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Comparator;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.Part;


/**
 * The persistent class for the touristicplaces database table.
 * 
 */
@Entity
@Table(name="touristicplaces")
@NamedQuery(name="Touristicplace.findAll", query="SELECT t FROM Touristicplace t")
public class Touristicplace implements Serializable , Comparator<Touristicplace> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTouristicPlaces;

	private String country;


	private String delegation;


	private String nameTouristicPlace;


	private String touristicPlaceImage;
	
	private String touristicPlaceImageLink;
	
	
	
	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="touristicplace")
	private List<Event> events;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="touristicplace")
	private List<Experience> experiences;

	@OneToMany(mappedBy="touristicplace", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private List<Offer> offers;
	
	@OneToMany(mappedBy="touristicplace",cascade=CascadeType.ALL) 
	private  List<WL_TP> ListWT;
	
	@Transient
	private Part file;

	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	 
	public Touristicplace() {
	}


	public List<WL_TP> getListWT() {
		return ListWT;
	}

	public void setListWT(List<WL_TP> listWT) {
		ListWT = listWT;
	}
	
	public String setTouristicPlaceImageLink() {
		final String savePath = "C:/Users/Fadi/Desktop/WorkspaceTestIntegration/PI/PI-web/src/main/webapp/resources/savedImages/"; 
		
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        try {
			file.write(savePath + File.separator + this.getTouristicPlaceImage());
			this.touristicPlaceImageLink = "savedImages" + "/" + this.getTouristicPlaceImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return touristicPlaceImageLink;
	}



	public String getTouristicPlaceImageLink() {
		if(touristicPlaceImageLink == null || touristicPlaceImageLink.length() == 0) {
			setTouristicPlaceImageLink();
		}
		return touristicPlaceImageLink;
	}
	public void setTouristicPlaceImageLink(String touristicPlaceImageLink) {
		this.touristicPlaceImageLink = touristicPlaceImageLink;
	}


	public int getIdTouristicPlaces() {
		return this.idTouristicPlaces;
	}

	public void setIdTouristicPlaces(int idTouristicPlaces) {
		this.idTouristicPlaces = idTouristicPlaces;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDelegation() {
		return this.delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getNameTouristicPlace() {
		return this.nameTouristicPlace;
	}

	public void setNameTouristicPlace(String nameTouristicPlace) {
		this.nameTouristicPlace = nameTouristicPlace;
	}

	public String getTouristicPlaceImage() {
		return touristicPlaceImage;
	}

	public String setTouristicPlaceImage() {
		this.touristicPlaceImage = this.file.getSubmittedFileName();
		return this.touristicPlaceImage;
	}
	public void setTouristicPlaceImage(String touristicPlaceImage) {
		this.touristicPlaceImage = touristicPlaceImage;
	}
	

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setTouristicplace(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setTouristicplace(null);

		return event;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setTouristicplace(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setTouristicplace(null);

		return experience;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	@Override
	public int compare(Touristicplace o1, Touristicplace o2) {
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ListWT == null) ? 0 : ListWT.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((delegation == null) ? 0 : delegation.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((experiences == null) ? 0 : experiences.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + idTouristicPlaces;
		result = prime * result + ((nameTouristicPlace == null) ? 0 : nameTouristicPlace.hashCode());
		result = prime * result + ((offers == null) ? 0 : offers.hashCode());
		result = prime * result + ((touristicPlaceImage == null) ? 0 : touristicPlaceImage.hashCode());
		result = prime * result + ((touristicPlaceImageLink == null) ? 0 : touristicPlaceImageLink.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Touristicplace other = (Touristicplace) obj;
		if (ListWT == null) {
			if (other.ListWT != null)
				return false;
		} else if (!ListWT.equals(other.ListWT))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (delegation == null) {
			if (other.delegation != null)
				return false;
		} else if (!delegation.equals(other.delegation))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (experiences == null) {
			if (other.experiences != null)
				return false;
		} else if (!experiences.equals(other.experiences))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (idTouristicPlaces != other.idTouristicPlaces)
			return false;
		if (nameTouristicPlace == null) {
			if (other.nameTouristicPlace != null)
				return false;
		} else if (!nameTouristicPlace.equals(other.nameTouristicPlace))
			return false;
		if (offers == null) {
			if (other.offers != null)
				return false;
		} else if (!offers.equals(other.offers))
			return false;
		if (touristicPlaceImage == null) {
			if (other.touristicPlaceImage != null)
				return false;
		} else if (!touristicPlaceImage.equals(other.touristicPlaceImage))
			return false;
		if (touristicPlaceImageLink == null) {
			if (other.touristicPlaceImageLink != null)
				return false;
		} else if (!touristicPlaceImageLink.equals(other.touristicPlaceImageLink))
			return false;
		return true;
	}
	

}