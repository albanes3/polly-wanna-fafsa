package com.westsandbox.application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;

public class RestaurantPickerDAO implements IRestaurantPickerDAO {

	@PersistenceContext
	private EntityManager em;
	//TODO: check for adding same guest/rest object twice
	@Override
	public Guest addGuest(Guest g) {
		em.persist(g);
		return g;
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		em.persist(r);
		return r;
	}

	@Override
	public void mapRestToGuest(int guestId, int restId) {
		Restaurant r = em.find(Restaurant.class, restId);
		Guest g = em.find(Guest.class, guestId);
		g.getRestaurants().add(r);
		r.getGuests().add(g);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> retrieveAllRest() {
		Query q = em.createQuery(("select r from Restaurant r"));		
		return q.getResultList();
	}

	@Override
	public void deleteRestaurant(int restId) {
		Restaurant r = em.find(Restaurant.class, restId);
		em.remove(r);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		//Restaurant r = em.find(Restaurant.class, rest)
		//TODO: how to update record
		// deletes record upon update: return em.merge(r);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> retrieveAllGuests() {
		Query q = em.createQuery(("select g from Guest g"));		
		return q.getResultList();
	}

	@Override
	public void deleteGuest(int guestId) {
		Guest g = em.find(Guest.class, guestId);
		em.remove(g);
	}

	@Override
	public Guest updateGuest(Guest g) {
		// TODO Auto-generated method stub
//		return em.merge(g);
		//TODO: how to update record
		// deletes record upon update: return em.merge(r);
		return null;
	}

}
