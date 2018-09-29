package tn.esprit.PI.PI.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PI.PI.services.CommentaireServicesLocal;
import tn.esprit.PI.persistance.Event;

@ManagedBean
@SessionScoped
public class EventBean {
	@EJB
	private CommentaireServicesLocal comServices;
	private Event e=new Event();
	
	@PostConstruct
	public void init() {
		
		setE(comServices.findByID(1));

	}

	public Event getE() {
		return e;
	}

	public void setE(Event e) {
		this.e = e;
	}
}
