package tn.esprit.PI.PI.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.Challenge;
import tn.esprit.PI.persistance.Note;
import tn.esprit.PI.persistance.NotePK;

/**
 * Session Bean implementation class NoteServiceEJB
 */
@Stateless
@LocalBean
public class NoteServiceEJB implements NoteServiceEJBLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public NoteServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long NbrParticipantChallenge(Challenge ch) {
		return (Long) em.createQuery("select count(*) from Note n where n.challenge = :x").setParameter("x", ch)
				.getSingleResult();
	}

	@Override
	public void Participer(Note n, int idChallenge, int idUser) {
		NotePK npk = new NotePK();
		npk.setChallengePK(idChallenge);
		npk.setUserPK(idUser);
		n.setNotePK(npk);
		em.persist(n);

	}

	@Override
	public boolean membre(Challenge ch, User u) {
		int z = em.createQuery("select n from Note n where n.challenge = :c AND n.user = :u", Note.class)
				.setParameter("c", ch).setParameter("u", u).getResultList().size();
		if (z > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Note> getAll() {
		List<Note> l = em.createQuery("select e from Note e ", Note.class).getResultList();
		System.out.println("getallllll()");
		return l;
	}

	@Override
	public List<Note> listParticipant(Challenge ch) {
		return em.createQuery("select n from Note n where n.challenge = :x ORDER BY n.note DESC", Note.class)
				.setParameter("x", ch).getResultList();

	}

	@Override
	public Note findNote(Challenge ch, User u) {
		return em.createQuery("select n from Note n where n.challenge = :c AND n.user = :u", Note.class)
				.setParameter("c", ch).setParameter("u", u).getSingleResult();
	}

	@Override
	public void NeParticipePlus(Challenge ch, User u) {
		Note n = em.createQuery("select n from Note n where n.challenge = :c AND n.user = :u", Note.class)
				.setParameter("c", ch).setParameter("u", u).getSingleResult();
        System.out.println("neparticipepluuuuuuuuuuus"+n.getNote());
		em.remove(em.merge(n));

	}

	@Override
	public Long listCommentaire(User u, Date startDate, Date endDate) {
		Long v = (Long) em
				.createQuery(
						"select count(*) from Commentaire c inner join c.User as cuser  where cuser.id = :x AND c.id.dateCommentaire BETWEEN :dd AND :ed")
				.setParameter("x", u.getId()).setParameter("dd", startDate, TemporalType.DATE)
				.setParameter("ed", endDate, TemporalType.DATE).getSingleResult();
		System.out.println("Commmmmmmmentaire" + v);
		return v;
	}

	@Override
	public boolean topCommentedEventByUser(User u) {
		Object[] e = (Object[]) em
				.createQuery(
						"select c.event.user.id,count(*) as nb from Commentaire c group by c.event.idEvent order by nb")
				.setFirstResult(0).setMaxResults(1).getSingleResult();
		System.out.println("toooooooooooooooooooop" + e[0]);
		if (e[0].equals(u.getId())) {
			return true;
		}
		return false;
	}

	@Override
	public Long NbrAmis(User u, Date startDate, Date endDate) {
		Long v = (Long) em
				.createQuery(
						"select count(*) from FriendsInvitation f inner join f.userSender as fuser  where fuser.id = :x AND f.state=TRUE AND f.date BETWEEN :dd AND :ed")
				.setParameter("x", u.getId()).setParameter("dd", startDate, TemporalType.DATE)
				.setParameter("ed", endDate, TemporalType.DATE).getSingleResult();
		System.out.println("friennnnnnnnnnnnnnnnnds" + v);
		return v;
	}

	@Override
	public Long NbrExperience(User u, Date startDate, Date endDate) {
		Long v = (Long) em
				.createQuery(
						"select count(*) from Experience e inner join e.user as euser  where euser.id = :x AND e.id.date BETWEEN :dd AND :ed")
				.setParameter("x", u.getId()).setParameter("dd", startDate, TemporalType.DATE)
				.setParameter("ed", endDate, TemporalType.DATE).getSingleResult();
		System.out.println("exppppppppppp" + v);
		return v;
	}

	@Override
	public User gangnant(Challenge ch) {
		List<Note> l = em.createQuery("select n from Note n where n.challenge = :x ORDER BY n.note DESC", Note.class)
				.setParameter("x", ch).getResultList();
		return l.get(0).getUser();
	}

	@Override
	public List<Challenge> MesChallenge(User u) {
		List<Note> l = em.createQuery("select n from Note n where n.user = :x", Note.class).setParameter("x", u)
				.getResultList();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx" + l.size());
		List<Challenge> lch = new ArrayList<Challenge>();
		for (Note n : l) {
			Challenge c = n.getChallenge();
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxx" + c.getName());
			lch.add(c);
		}
		System.out.println("xxxxxxxxxxxxxxxxxxxxx" + lch.size());
		return lch;
	}

	@Override
	public void CalculeNote(Note n) {
		long nbrcomment = listCommentaire(n.getUser(), n.getChallenge().getDateDebut(), n.getChallenge().getDateFin());
		long nbramis = NbrAmis(n.getUser(), n.getChallenge().getDateDebut(), n.getChallenge().getDateFin());
		long nbrexp = NbrExperience(n.getUser(), n.getChallenge().getDateDebut(), n.getChallenge().getDateFin());
		boolean topevent = topCommentedEventByUser(n.getUser());
		int note = 0;
		if (topevent == true) {
			note = note + 10;
		}
		note = note + (int) nbrcomment * 2;
		note = note + (int) nbramis * 3;
		note = note + (int) nbrexp * 4;
		if (n.getChallenge().getDateFin().after(new Date())) {
			n.setNote(note);
			em.merge(n);
		}
	}

}