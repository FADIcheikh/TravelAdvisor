package tn.esprit.PI.PI.services;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.el.ImportHandler;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PI.persistance.Offer;
import tn.esprit.PI.persistance.Reservationoffer;
import tn.esprit.PI.persistance.Touristicplace;
import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.WL_TP;
import tn.esprit.PI.persistance.WL_TPId;
import tn.esprit.PI.persistance.WishList;

/**
 * Session Bean implementation class WishListServices
 */
@Stateless
@LocalBean
public class WishListServices implements WishListServicesLocal {
	@PersistenceContext(unitName="PI-ejb")
    EntityManager em;
    /**
     * Default constructor. 
     */
    public WishListServices() {
        // TODO Auto-generated constructor stub
    }

    //Add & Affectation
    
    @Override
	public void addWishList(WishList Wi) {
	
	System.out.println("_________________Add wishList Started");
		
		em.persist(Wi);
	}
  
	@Override
	public void addTPToWish(Touristicplace tp, WishList wi,int importance) {
String nomTP=tp.getNameTouristicPlace();
tp=em.createQuery("SELECT t FROM Touristicplace t WHERE t.nameTouristicPlace=?1",Touristicplace.class)
.setParameter(1,nomTP).getSingleResult();
String nomWL=wi.getName();
wi=em.createQuery("SELECT w FROM WishList w WHERE w.Name=?1",WishList.class)
.setParameter(1,nomWL).getSingleResult();	
WL_TPId id=new WL_TPId(tp.getIdTouristicPlaces(), wi.getIdWishList());
	WL_TP wt=new WL_TP(id,tp,wi,importance);
	em.persist(wt);
	}

	@Override
	public WishList findById(int id) {
		return em.find(WishList.class, id);		
	}

	@Override
	public Touristicplace findTPById(int id) {
		return em.find(Touristicplace.class, id);		
	}
	

	@Override
	public List<WishList> findAll(User u) {
		return em.createQuery("select l from WishList l where l.user=?1",WishList.class).setParameter(1,u)
				.getResultList();
	}



	@Override
	public List<Touristicplace> findTpOfOneWl(int id) {
		WishList w=findById(id);
		Query query = em.createQuery("SELECT w.touristicplace FROM WL_TP w where w.wishList=?1",Touristicplace.class)
				.setParameter(1,w);
		List<Touristicplace> Touristicplaces= query.getResultList();
		System.out.println("+++++++++++++++++++++++++++++"+Touristicplaces.size());
		return Touristicplaces;
	}



	@Override
	public void delete(WishList w) {
		em.remove(em.merge(w));
		
		
	}

	
	
	@Override
	public List<Touristicplace> findAllTouristicPlaces() {
		
		/*String jpql = "SELECT p FROM Touristicplace p" ;
				Query query = em.createQuery(jpql);
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+query.getFirstResult());
				return query.getResultList();*/
				
	System.out.println("find all started!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Query q= em.createQuery("select t from Touristicplace t",Touristicplace.class);
				return q.getResultList();
	}
	
	@Override
	public User chercherUserParId(String id) {
		
		return em.find(User.class, id);
	}


	@Override
	public Touristicplace chercherTpParId(int id) {
		
		return em.find(Touristicplace.class, id);
	}

	@Override
	public List<WishList> findByName(String name) {
		
		return null;
	}

	@Override
	public List<Offer> FindOffers(Touristicplace t) {
		//Query q= em.createQuery("select t from Event t",Touristicplace.class);
		return em.createQuery("select o from Offer o where o.touristicplace= :a",Offer.class).setParameter("a", t).getResultList();

	}

	@Override
	public Number CountReservation(int x) {
		
	return (Number) em.createQuery("select count(*) from Reservationoffer r inner join r.offer as foffer  where foffer.IdOffer = :x").setParameter("x",x).getSingleResult();
	
	
	/*
	 * select count(r.reservationofferPK.offer) from Reservationoffer r where r.offer.IdOffer= :x").setParameter("x",x).getSingleResult(); 
	 * em
				.createQuery("select count(Reservationoffer),r.Offer.IdOffer from Reservationoffer  r ,Offer o,TouristicPlace tp where  o.touristicplace= and count(r.Offer.IdOffer) IN (select count(r.Offer.IdOffer) from Reservation limit(5) group by Offer.IdOffer order count(r.Offer.IdOffer) DESC)",Offer.class).getResultList();
		
	*/}
	@Override
	public Offer findOfferById(int id){
		 return em.find(Offer.class, id);
	}
	@Override
	public void update(WishList w) {
	WishList w1=findById(w.getIdWishList());
	w1.setName(w.getName());
	em.merge(w1);
	em.flush();
	}
		
	
	



}
