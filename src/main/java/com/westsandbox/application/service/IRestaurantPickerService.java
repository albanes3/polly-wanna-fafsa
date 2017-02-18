package com.westsandbox.application.service;

import java.util.List;

import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;

public interface IRestaurantPickerService {
	//tested
	public Guest addGuest(Guest g);
	public Restaurant addRestaurant(Restaurant r);
	public void mapRestToGuest(int guestId, int restId);
	public List<Restaurant> retrieveAllRest();
	public void deleteRestaurant(int restId);
	public Restaurant updateRestaurant(Restaurant r);
	public List<Guest> retrieveAllGuests();
	public void deleteGuest(int guestId);
	public Guest updateGuest(Guest g);
	
	//not tested
	public Restaurant pickRestaurant();
	public void sendEmailToGuest();
}
