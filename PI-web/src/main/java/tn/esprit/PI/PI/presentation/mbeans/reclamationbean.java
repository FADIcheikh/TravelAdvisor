package tn.esprit.PI.PI.presentation.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PI.PI.services.ReclamationComEventService;
import tn.esprit.PI.PI.services.ReclamationComEventService;
import tn.esprit.PI.persistance.ReclamationComEvent;
import tn.esprit.PI.persistance.User;



@ManagedBean(name="reccomeBean")
@SessionScoped
public class reclamationbean {
	

	
	 @EJB
	 ReclamationComEventService service ;
	 private List<ReclamationComEvent> reclamations = new ArrayList<ReclamationComEvent>();
	 private ReclamationComEvent recalamtion=new ReclamationComEvent();
	 private List<User> userss = new ArrayList<User>();
	 private Boolean render=false;
	 private Boolean displayForm=false;
	 private boolean etat;
	
	 
	 @PostConstruct
	 public void init() {
		 reclamations = service.findAllrec();
		 
	 }
	 
	 public ReclamationComEvent afficherClaim(int id) {
			return service.findrec(id);
		}
	 
	 public void GetClaimTraite()
		{reclamations = service.findTreatedClaims();
		recalamtion = new ReclamationComEvent();}
		
		public void GetClaimUnTraited()
		{reclamations = service.findUntreatedClaims();
		recalamtion = new ReclamationComEvent();}
		
		public void traiterClaim(ReclamationComEvent cl){
			service.traiterClaim(cl);
		}
	 
	 
	public void doAdd() {
		Date d= new Date();
		recalamtion.setDatereclamation(d);
			service.addReclamation(recalamtion);
			setDisplayForm(false);
			init();

	}
	
	 public void doDelete() {
			service.delete(recalamtion);;
			setDisplayForm(false);
			init();
	}
	 
	 public void doCancel() {
			setDisplayForm(false);
	}

	 public void addMessage() {
	        String summary = etat ? "Approved" : "Unapproved";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	}
	 
	 
	  
	 
	public List<ReclamationComEvent> getReclamations() {
		return reclamations;
	}
	public void setReclamations(List<ReclamationComEvent> reclamations) {
		this.reclamations = reclamations;
	}
	public ReclamationComEvent getRecalamtion() {
		return recalamtion;
	}
	public void setRecalamtion(ReclamationComEvent recalamtion) {
		this.recalamtion = recalamtion;
	}
	public Boolean getDisplayForm() {
		return displayForm;
	}
	public void setDisplayForm(Boolean displayForm) {
		this.displayForm = displayForm;
	}
	public ReclamationComEventService getService() {
		return service;
	}
	public void setService(ReclamationComEventService service) {
		this.service = service;
	}
	 
	public Boolean getRender() {
		return render;
	}

	public void setRender(Boolean render) {
		this.render = render;
	}



	public List<User> getUserss() {
		return userss;
	}



	public void setUserss(List<User> userss) {
		this.userss = userss;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	

}
