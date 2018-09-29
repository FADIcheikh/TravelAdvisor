package tn.esprit.PI.PI.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PI.persistance.Challenge;
import tn.esprit.PI.persistance.Commentaire;
import tn.esprit.PI.persistance.CommentairePK;
import tn.esprit.PI.persistance.Event;
import tn.esprit.PI.persistance.User;

/**
 * Session Bean implementation class CommentaireServiceEJB
 */
@Stateless
@LocalBean
public class CommentaireService implements CommentaireServicesLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CommentaireService() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void createCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		em.persist(commentaire);
	}

	@Override
	public void replaceCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		em.merge(commentaire);
	}

	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		em.remove(em.merge(commentaire));
		
	}
	

	@Override
	public List<Commentaire> displayCommentaire(int idEvent) {
	
		return em.createQuery("select e from Commentaire e where e.id.idEvent=:x ", Commentaire.class)
				.setParameter("x", idEvent)
				.getResultList();	
	
		
	}

	@Override
	public Commentaire findCommentaireById(CommentairePK id) {
		return em.createQuery("select e from Commentaire e where e.id=:x", Commentaire.class)
				.setParameter("x", id)

				.getSingleResult();	
	}
	@Override
	public List<User> ActiveUsers()
	{
		
		List<User> a = em.createQuery("SELECT distinct u FROM Commentaire c , User u  WHERE u.id = c.id.idSimpleUser ", User.class).getResultList();	
		return a ;
	}

	@Override
	public List<User> inActiveUsers() {
		List<User> a = em.createQuery("SELECT distinct u FROM Commentaire c , User u  WHERE u.id <> c.id.idSimpleUser ", User.class).getResultList();	
		return a ;
	}
	@Override
	public Event findByID(int id) {
		return em.find(Event.class, id);

	}

//	@Override
//	public User getMostActifUser()
//	{
//		 User a = em.createQuery("SELECT u FROM Commentaire c  join  c.User u  WHERE c.id.idSimpleUser=: u.id GROUP BY u.id", User.class).getSingleResult();	
//		return a;
//	}
	
}
