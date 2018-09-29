package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PI.persistance.ReclamationComEvent;


@Remote
public interface ReclamationComEventServiceRemote {

	void addReclamation(ReclamationComEvent rec);
	void updateReclamation(ReclamationComEvent rec);
	void delete(ReclamationComEvent rec);
	ReclamationComEvent findrec(int id);
	List<ReclamationComEvent> findAllrec();
	List<ReclamationComEvent> findReclmationByDateCreation(Date datereclamation);
	
}
