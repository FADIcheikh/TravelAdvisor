package tn.esprit.PI.PI.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import tn.esprit.PI.persistance.Touristicplace;


/**
 * Session Bean implementation class TouristicPlaceService
 */
@Stateless
@LocalBean
public class TouristicPlaceService implements TouristicPlaceServiceLocal {

	@PersistenceContext(unitName = "PI-ejb")
	EntityManager em;

	public List<Touristicplace> customers = new ArrayList<Touristicplace>();

	/**
	 * Default constructor.
	 */
	public TouristicPlaceService() {
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void updateTouristicplace(Touristicplace touristic) {
		Touristicplace touristicplace = findTouristicplaceById(touristic.getIdTouristicPlaces());

		touristicplace.setNameTouristicPlace(touristic.getNameTouristicPlace());
		touristicplace.setCountry(touristic.getCountry());
		touristicplace.setDelegation(touristic.getDelegation());
		touristicplace.setTouristicPlaceImageLink(touristic.getTouristicPlaceImageLink());
		touristicplace.setTouristicPlaceImage(touristic.getTouristicPlaceImage());
        
		em.persist(touristicplace);
		em.flush();
	}
	
	@Override
	public boolean removeTouristicPlace(int id) {
		Touristicplace touristicplace = findTouristicplaceById(id);
		if (touristicplace != null) {
			em.remove(touristicplace);
			return true;
		}
		return false;
	}

	@Override
	public void addTouristicPlace(Touristicplace touristicplace) {
		em.persist(touristicplace);
		em.flush();
	}

	@Override
	public List<Touristicplace> findAllTouristicplace() {
		Query query = em.createQuery("SELECT t FROM Touristicplace t");
		return (List<Touristicplace>) query.getResultList();
	}

	@Override
	public Touristicplace findTouristicplaceById(int id) {
		return em.find(Touristicplace.class, id);
	}



	public List<Touristicplace> allTouristicPlaceOrderWithGretherOffre() {
		String query = "select t.idTouristicPlaces, count(*) "
				+ "from finalpijee.touristicplaces t "
				+ "inner join finalpijee.offer o on o.touristicplace_idTouristicPlaces = t.idTouristicPlaces "
				+ "inner join finalpijee.reservationoffer r on r.offer_idOffer = o.idOffer "
				+ "group by t.idTouristicPlaces "
				+ "order by count(*) desc";
		
		Query createNativeQuery = em.createNativeQuery(query);
		List<Object[]> resultList = createNativeQuery.getResultList();
		List<Touristicplace> touristicplaces = new ArrayList<>();
		for (Object[] id : resultList) {
			touristicplaces.add(this.findTouristicplaceById((Integer) id[0]));
		}
		return touristicplaces;
	}
	
	public Touristicplace bestTouristicPlaceWithGretherOffre() {
		return allTouristicPlaceOrderWithGretherOffre().get(0);
	}
	
	@Override
		public List<Touristicplace> findTouristicplaceByName(String name) {
			Query query = em.createQuery("SELECT c FROM Touristicplace c where c.nameTouristicPlace like:search").setParameter("search", "%"+name+"%");
			List<Touristicplace> touristicplaces = query.getResultList();
			return touristicplaces;
		}



	
}
