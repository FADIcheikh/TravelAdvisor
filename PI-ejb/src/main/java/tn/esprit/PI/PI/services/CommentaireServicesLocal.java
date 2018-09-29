package tn.esprit.PI.PI.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.PI.persistance.Challenge;
import tn.esprit.PI.persistance.Commentaire;
import tn.esprit.PI.persistance.CommentairePK;
import tn.esprit.PI.persistance.Event;
import tn.esprit.PI.persistance.User;

@Local
public interface CommentaireServicesLocal {
	public void createCommentaire(Commentaire commentaire);
	public void replaceCommentaire(Commentaire commentaire);
	public void deleteCommentaire(Commentaire commentaire);
	public List<Commentaire> displayCommentaire(int idEvent);
	public Commentaire findCommentaireById(CommentairePK id);
	List<User> ActiveUsers();
	List<User> inActiveUsers();
	public Event findByID(int id);
}
