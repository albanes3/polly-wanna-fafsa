package com.westsandbox.application.dao;

import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;

import java.util.List;

public interface IRestaurantPickerDAO {
	public Guest addGuest(Guest g);
	public Restaurant addRestaurant(Restaurant r);
	public void mapRestToGuest(int guestId, int restId);
	public List<Restaurant> retrieveAllRest();
	public void deleteRestaurant(int restId);
	public Restaurant updateRestaurant(Restaurant r);
	public List<Guest> retrieveAllGuests();
	public void deleteGuest(int guestId);
	public Guest updateGuest(Guest g);
}
