package tn.esprit.PI.PI.services;

import java.awt.Event;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.PI.persistance.Offer;
import tn.esprit.PI.persistance.Reservationoffer;
import tn.esprit.PI.persistance.Touristicplace;
import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.WishList;
@Remote
public interface WishListServicesLocal {
	 void addWishList(WishList Wi) ;
	void addTPToWish(Touristicplace tp,WishList wi,int importance);
	WishList findById(int id);
	List<WishList> findAll(User u);
	List<Touristicplace> findAllTouristicPlaces();
    List<WishList> findByName(String name) ;
    List<Touristicplace> findTpOfOneWl(int id);
	Touristicplace chercherTpParId(int id);
	 User chercherUserParId(String id) ;
	 void delete(WishList w) ;
	Touristicplace findTPById(int id) ;
	List<Offer> FindOffers(Touristicplace t);
	Number CountReservation(int x);
	Offer findOfferById(int id);
	 void update(WishList w);
}