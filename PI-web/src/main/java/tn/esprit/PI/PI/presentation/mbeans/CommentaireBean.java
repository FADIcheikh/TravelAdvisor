package tn.esprit.PI.PI.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PI.PI.services.CommentaireServicesLocal;
import tn.esprit.PI.persistance.Commentaire;
import tn.esprit.PI.persistance.CommentairePK;
import tn.esprit.PI.persistance.User;

@ManagedBean
@SessionScoped
public class CommentaireBean {
	
	public CommentaireBean() {
	super();
}

Date d = new Date();
private User u = new User();

@EJB
private CommentaireServicesLocal comServices;

private Commentaire ComModif = new Commentaire();
private CommentairePK cPK = new CommentairePK();

private CommentairePK cId = new CommentairePK();
private Commentaire Com = new Commentaire(cId);

private List<Commentaire> coms;


private boolean formDisplayed = false;
private boolean formDisplayedForUpdate = false;

@PostConstruct
public void init() {
	
	coms = comServices.displayCommentaire(1);

}



public String DoSave() {

	
	
	cId.setIdSimpleUser(u.getId());
	cId.setDateCommentaire(d);
	cId.setIdEvent(1);
	String NavigateTo = null;
	comServices.createCommentaire(Com);
	coms = comServices.displayCommentaire(1);
	DoCancel();
	System.out.println(u.getId());

	return NavigateTo;

}

public String DoUpdate() {

	if (ComModif.getId().getIdSimpleUser()==u.getId()) {
		String NavigateTo = null;

		comServices.replaceCommentaire(ComModif);
		coms = comServices.displayCommentaire(1);
		DoCancel();
		return NavigateTo;
	} else {
		DoCancel();
	}

	return null;

}



public String DoRemove() {
	String NavigateTo = null;
	if (ComModif.getId().getIdSimpleUser()==u.getId()) {
		comServices.deleteCommentaire(ComModif);
		coms = comServices.displayCommentaire(1);
		DoCancel();
		return NavigateTo;

	}

	return NavigateTo;
}

public String DoDisplay() {
	String NavigateTo = null;
	comServices.displayCommentaire(1);
	return NavigateTo;

}

public String DoDisplayUpdate() {
	String NavigateTo = null;
	formDisplayedForUpdate = true;
	comServices.displayCommentaire(1);
	return NavigateTo;

}

public String DoNew() {
	String NavigateTo = null;
	formDisplayed = true;
	Com = new Commentaire(cId);
	return NavigateTo;

}

public String DoCancel() {
	String NavigateTo = null;
	coms = comServices.displayCommentaire(1);
	formDisplayed = false;
	formDisplayedForUpdate = false;
	return NavigateTo;
}

public Commentaire getCom() {
	return Com;
}

public void setCom(Commentaire com) {
	Com = com;
}

public List<Commentaire> getComs() {
	return coms;
}

public void setComs(List<Commentaire> coms) {
	this.coms = coms;
}

public boolean isFormDisplayed() {
	return formDisplayed;
}

public void setFormDisplayed(boolean formDisplayed) {
	this.formDisplayed = formDisplayed;
}

public Commentaire getComModif() {
	return ComModif;
}

public void setComModif(Commentaire comModif) {
	ComModif = comModif;
}

public CommentairePK getcPK() {
	return cPK;
}

public void setcPK(CommentairePK cPK) {
	this.cPK = cPK;
}

public boolean isFormDisplayedForUpdate() {
	return formDisplayedForUpdate;
}

public void setFormDisplayedForUpdate(boolean formDisplayedForUpdate) {
	this.formDisplayedForUpdate = formDisplayedForUpdate;
}



public User getU() {
	return u;
}



public void setU(User u) {
	this.u = u;
}




}
