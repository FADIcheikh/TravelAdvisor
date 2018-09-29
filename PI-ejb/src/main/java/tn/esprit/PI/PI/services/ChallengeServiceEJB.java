package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import tn.esprit.PI.persistance.Challenge;

/**
 * Session Bean implementation class ChallengeServiceEJB
 */
@Stateless
@LocalBean
public class ChallengeServiceEJB implements ChallengeServiceEJBLocal {

	@PersistenceContext
	EntityManager em;

	public ChallengeServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Challenge findByID(int id) {
		return em.find(Challenge.class, id);
	}

	@Override
	public void Ajouter(Challenge c) {
		em.merge(c);
	}

	@Override
	public void Supprimer(Challenge c) {
		em.remove(em.merge(c));

	}

	@Override
	public void Modifier(Challenge c) {
		em.merge(c);
	}

	@Override
	public Challenge Afficher(int id) {
		return em.find(Challenge.class, id);

	}

	@Override
	public List<Challenge> listChallenge() {
		System.out.println("--------------------------");
		List<Challenge> l = em.createQuery("select e from Challenge e ").getResultList();
		System.out.println("--------------------------" + l.size());
		return l;
	}

	@Override
	public List<Challenge> findByName(String name) {
		Query query = em.createQuery("SELECT c FROM Challenge c where c.name like:search").setParameter("search", name);
		List<Challenge> challengs = query.getResultList();
		return challengs;
	}

	@Override
	public List<Challenge> getChallengeByPeriod(Date startDate, Date endDate) {
		return em.createQuery("select c from Challenge c where c.DateDebut = :dd AND c.DateFin = :ed", Challenge.class)
				.setParameter("dd", startDate, TemporalType.DATE).setParameter("ed", endDate, TemporalType.DATE)
				.getResultList();
	}

	@Override
	public List<Challenge> listAvailableChallenges() {
		return em.createQuery("select c from Challenge c where :sysdate BETWEEN c.DateDebut AND c.DateFin",
				Challenge.class).setParameter("sysdate", new Date(), TemporalType.DATE).getResultList();
	}

}
