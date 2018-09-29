package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.PI.persistance.Challenge;

@Local
public interface ChallengeServiceEJBLocal {

	public void Ajouter(Challenge c);
	public void Supprimer(Challenge c);
	public void Modifier(Challenge c);
	public Challenge Afficher(int id);
	public List<Challenge> listChallenge();
	public List<Challenge> findByName(String name);
	public List<Challenge> getChallengeByPeriod(Date startDate, Date endDate);
	public List<Challenge> listAvailableChallenges();
	public Challenge findByID(int id);
	

}
