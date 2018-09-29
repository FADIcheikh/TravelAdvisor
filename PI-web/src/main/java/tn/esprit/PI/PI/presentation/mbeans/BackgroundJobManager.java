package tn.esprit.PI.PI.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import tn.esprit.PI.PI.services.NoteServiceEJBLocal;
import tn.esprit.PI.persistance.Note;

@Singleton
public class BackgroundJobManager {
	@EJB
	NoteServiceEJBLocal ns;

	@Schedule(hour = "*", minute = "*/10", second = "0", persistent = false)
	public void someQuarterlyJob() {
		// Do your job here which should run every 10 minute of hour.
		List<Note> l = ns.getAll();
		for (Note note : l) {
			ns.CalculeNote(note);
		}

	}
}
