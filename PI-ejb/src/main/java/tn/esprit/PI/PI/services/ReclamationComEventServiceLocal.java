package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.PI.persistance.ReclamationComEvent;
import tn.esprit.PI.persistance.User;



@Local
public interface ReclamationComEventServiceLocal {

	void addReclamation(ReclamationComEvent rec);
	void updateReclamation(ReclamationComEvent rec);
	void delete(ReclamationComEvent rec);
	ReclamationComEvent findrec(int id);
	List<ReclamationComEvent> findAllrec();
	List<ReclamationComEvent> findReclmationByDateCreation(Date datereclamation);
	//void addClaim(User user, Event event, ReclamationComEvent claim);
	List<ReclamationComEvent> findUntreatedClaims();
	void traiterClaim(ReclamationComEvent cl);
	List<ReclamationComEvent> findTreatedClaims();
	List<ReclamationComEvent> findClaimsByUser(User userc);
}
