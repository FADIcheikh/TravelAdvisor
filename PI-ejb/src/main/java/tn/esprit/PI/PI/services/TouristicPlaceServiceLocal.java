package tn.esprit.PI.PI.services;

import java.util.List;

import javax.ejb.Local;


import tn.esprit.PI.persistance.Touristicplace;

@Local
public interface TouristicPlaceServiceLocal {
	
	/**
	 * 
	 * @param touristicplace
	 */
	void addTouristicPlace(Touristicplace touristicplace);
	public List<Touristicplace> allTouristicPlaceOrderWithGretherOffre();

	/**
	 * 
	 * @return
	 */
	public List<Touristicplace> findAllTouristicplace();

	/**
	 * Finds the touristicplace by id
	 * 
	 * @param id
	 * @return returns the touristicplace
	 */
	public Touristicplace findTouristicplaceById(int id);
	
	public List<Touristicplace> findTouristicplaceByName(String name);

	public boolean removeTouristicPlace(int id);

	/**
	 * updates the touristicplace in the database
	 * 
	 * @param touristicplace
	 */
	public void updateTouristicplace(Touristicplace touristicplace);
}
