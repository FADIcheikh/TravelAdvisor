package tn.esprit.PI.PI.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.Challenge;
import tn.esprit.PI.persistance.Note;

@Local
public interface NoteServiceEJBLocal {
	public Long NbrParticipantChallenge(Challenge ch);
	public List<Note> getAll();
	public void Participer(Note n,int idChallenge,int idUser);
	public boolean membre(Challenge ch, User u) ;
	public List<Note> listParticipant(Challenge ch);
	public Note findNote(Challenge ch, User u);
	public void NeParticipePlus(Challenge ch, User u);
	public Long listCommentaire(User u,Date startDate, Date endDate);
	public boolean topCommentedEventByUser(User u);
	public Long NbrAmis(User u,Date startDate, Date endDate);
	public Long NbrExperience(User u,Date startDate, Date endDate);
	public User gangnant(Challenge ch);
	public List<Challenge> MesChallenge(User u);
	public void CalculeNote(Note n);
}