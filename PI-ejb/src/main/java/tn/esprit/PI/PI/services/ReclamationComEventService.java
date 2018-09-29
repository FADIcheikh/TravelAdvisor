package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import tn.esprit.PI.persistance.Commentaire;
import tn.esprit.PI.persistance.ReclamationComEvent;
import tn.esprit.PI.persistance.User;


/**
 * Session Bean implementation class ReclamationComEventService
 */
@Stateless
@LocalBean
public class ReclamationComEventService implements ReclamationComEventServiceRemote, ReclamationComEventServiceLocal {

	


	
	@PersistenceContext
	private EntityManager em;
	private ReclamationComEventService rec;
	//private EventServices e;
	private UserServices s;
	//private CommentaireService c;
	
    /**
     * Default constructor. 
     */
    public ReclamationComEventService() {
       
    }

	@Override
	public void addReclamation(ReclamationComEvent rec) {
		em.merge(rec);
		
	}
	
//	@Override
//	public void addClaim(User user, Event event, ReclamationComEvent claim) {
//
//		Object id = new CommentairePK(user.getId(), event.getIdEvent());
//		Commentaire cm = em.find(Commentaire.class, id);
//		
//		claim.setComevent(cm);
//		//claim.setEvent(event);
//
//		em.merge(claim);
//
//	}
	
	
	public Number CountReclamation(Commentaire x) {
		return (Number) em.createQuery("SELECT count(e) FROM ReclamationComEvent e WHERE e.comevent=:x").setParameter("x",x).getSingleResult();
	}
	
	
	
	@Override
	public void updateReclamation(ReclamationComEvent rec) {
		em.merge(rec);
		
	}

	@Override
	public void delete(ReclamationComEvent rec) {
		em.remove(em.merge(rec));
		
	}

	@Override
	public ReclamationComEvent findrec(int id) {
		return em.find(ReclamationComEvent.class, id);
	}
	


	@Override
	public List<ReclamationComEvent> findAllrec() {
		String requete = "select r from ReclamationComEvent r";
		return em.createQuery(requete, ReclamationComEvent.class).getResultList();
	}

	@Override
	public List<ReclamationComEvent> findClaimsByUser(User userc) {

		Query query = em.createQuery("SELECT c FROM ReclamationComEvent c WHERE user like:user").setParameter("user", userc);
		List<ReclamationComEvent> cls = query.getResultList();
		return cls;

	}
	
	
	@Override
	public List<ReclamationComEvent> findReclmationByDateCreation(Date datereclamation) {
		String requete = "select r from ReclamationComEvent r where r.datereclamation=:datereclamation";
		return em.createQuery(requete, ReclamationComEvent.class).setParameter("datereclamation", datereclamation, TemporalType.DATE).getResultList();
	}

	@Override
	public List<ReclamationComEvent> findTreatedClaims() {
		Query query = em.createQuery("SELECT c FROM ReclamationComEvent c WHERE c.etat = true", ReclamationComEvent.class);
		return query.getResultList();

	}

	@Override
	public List<ReclamationComEvent> findUntreatedClaims() {
		Query query = em.createQuery("SELECT c FROM ReclamationComEvent c WHERE c.etat = false", ReclamationComEvent.class);
		return query.getResultList();
	}
	
	@Override
	public void traiterClaim(ReclamationComEvent cl ) {
		cl.setEtat(true);
		em.merge(cl);
	}
	
	public ReclamationComEventService getRec() {
		return rec;
	}

	public void setRec(ReclamationComEventService rec) {
		this.rec = rec;
	}

	public UserServices getS() {
		return s;
	}

	public void setS(UserServices s) {
		this.s = s;
	}
}
