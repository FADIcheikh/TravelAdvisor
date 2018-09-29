package tn.esprit.PI.PI.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import tn.esprit.PI.PI.services.ChallengeServiceEJB;
import tn.esprit.PI.PI.services.ChallengeServiceEJBLocal;
import tn.esprit.PI.PI.services.NoteServiceEJBLocal;
import tn.esprit.PI.PI.services.UserServicesLocal;
import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.Challenge;
import tn.esprit.PI.persistance.Note;
import tn.esprit.PI.persistance.NotePK;

@ManagedBean(name = "chbean")
@SessionScoped
public class ChallengeBean {

	@EJB
	public ChallengeServiceEJBLocal cs;
	@EJB
	public NoteServiceEJBLocal ns;
	@EJB
	UserServicesLocal userservice;
	private Challenge c = new Challenge();
	private List<Challenge> challengs = new ArrayList<Challenge>();
	private List<Challenge> challengsAvailable = new ArrayList<Challenge>();
	private List<Challenge> Meschallengs = new ArrayList<Challenge>();
	private List<Challenge> ChallengeRecherche= new ArrayList<Challenge>();
	private String ch;
	private List<Note> listNote;
	private List<Challenge> listch;
	private User user;
	private boolean displayForm = false;
	private boolean m=true;
	public ChallengeBean() {
		super();
	}

	@PostConstruct
	public void init() {
		setDisplayForm(false);
		challengs = cs.listChallenge();
		challengsAvailable = cs.listAvailableChallenges();		
	}

	public void newChallenge() {

		c = new Challenge();
		displayForm = true;
	}
	public void doSave() {
		cs.Ajouter(c);
		init();
		displayForm = false;
	}
	public void ReturnToList() {
		setDisplayForm(false);
		challengs = cs.listChallenge();
	}

	public List<Challenge> findName() {
		displayForm = false;
		challengs = cs.findByName(ch);
		return challengs;

	}

	public List<Note> ListParticipant() {
		displayForm = true;
		 listNote=ns.listParticipant(getC());
		return listNote;

	}
	
	public List<Challenge> Meschallenge(int id) {
		return ns.MesChallenge(userservice.findUserByid(id));
        
	}
	public String AfficherChallenge(int id){
		setC(cs.findByID(id));
		return "/Challenge/AfficherChallengePass?faces-redirect=true";
	}

	public Long NbrParticipants() {
		return ns.NbrParticipantChallenge(getC());

	}

	public void doDelete() {
		cs.Supprimer(getC());
		init();
		setDisplayForm(false);
	}

	public void doUpdate() {
		cs.Modifier(getC());
		init();
		setDisplayForm(false);
	}
	
	public void updateNote() {
		/*List<Note> l=ns.getAll();
    	for (Note note : l) {
			ns.CalculeNote(note);
		}*/
		ns.topCommentedEventByUser(getUser());
		init();
		setDisplayForm(false);
	}

	public void Participate() {
		 m=ns.membre(getC(), getUser());
	
		Note n = new Note();
		n.setChallenge(getC());
		n.setUser(getUser());
		n.setNote(0);
	    ns.Participer(n,getC().getIdChallenge(),getUser().getId());
	    
	}
	
	public void NeParticipatePlus() {
		 setM(ns.membre(getC(), getUser()));
			if(m=true){
	    ns.NeParticipePlus(getC(),getUser());	}    
	}

	public void resultat() {
		displayForm = true;

	}

	public Challenge getC() {
		return c;
	}

	public void setC(Challenge c) {
		this.c = c;
	}

	public List<Challenge> getChallengs() {
		return challengs;
	}

	public void setChallengs(List<Challenge> challengs) {
		this.challengs = challengs;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public List<Challenge> getListch() {
		return listch;
	}

	public void setListch(List<Challenge> listch) {
		this.listch = listch;
	}

	public boolean isDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}

	public List<Challenge> getChallengsAvailable() {
		return challengsAvailable;
	}

	public void setChallengsAvailable(List<Challenge> challengsAvailable) {
		this.challengsAvailable = challengsAvailable;
	}

	public List<Note> getListNote() {
		return listNote;
	}

	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}

	public List<Challenge> getMeschallengs() {
		return Meschallengs;
	}

	public void setMeschallengs(List<Challenge> meschallengs) {
		Meschallengs = meschallengs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Challenge> getChallengeRecherche() {
		return ChallengeRecherche;
	}

	public void setChallengeRecherche(List<Challenge> challengeRecherche) {
		ChallengeRecherche = challengeRecherche;
	}

	public boolean isM() {
		return m;
	}

	public void setM(boolean m) {
		this.m = m;
	}
}