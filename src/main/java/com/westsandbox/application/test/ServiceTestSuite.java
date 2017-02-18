package com.westsandbox.application.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;
import com.westsandbox.application.service.IRestaurantPickerService;

public class ServiceTestSuite {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String("applicationContext.xml"));
		IRestaurantPickerService  service = (IRestaurantPickerService) context.getBean("service");

		// guest  and rest creation 1
		Guest g = new Guest("name1", "lastName1", "@gmail.com");
		Restaurant r = new Restaurant("restname", "zip", "City", "restPhoneNumber");
		service.addGuest(g);
		service.addRestaurant(r);
		System.out.println(g);

		// g2, r2
		Guest g2 = new Guest("name2", "lastName2", "@gmail.com");
		Restaurant r2 = new Restaurant("restname", "zip", "City", "restPhoneNumber");
		service.addGuest(g2);
		service.addRestaurant(r2);
		System.out.println(g2);

		// g3, r3
		Guest g3= new Guest("name3", "lastName3", "@gmail.com");
		Restaurant r3 = new Restaurant("restname", "zip", "City", "restPhoneNumber");
		service.addGuest(g3);
		service.addRestaurant(r3);
		System.out.println(g3);

		// g4, r4
		Guest g4 = new Guest("name4", "lastName4", "@gmail.com");
		Restaurant r4 = new Restaurant("restname", "zip", "City", "restPhoneNumber");
		service.addGuest(g4);
		service.addRestaurant(r4);
		System.out.println(g4);

		//add rest to guest
		//TODO: updateGuest removes g <-> r association
		service.mapRestToGuest(g.getId(), r.getRestId());
		service.mapRestToGuest(g2.getId(), r2.getRestId());
		service.mapRestToGuest(g3.getId(), r3.getRestId());
		service.mapRestToGuest(g4.getId(), r4.getRestId());
		
		//get all rests
		System.out.println(service.retrieveAllRest());

		//get all guests
		System.out.println(service.retrieveAllGuests());

		//update guest
		g.setFirstName("newFirstName");
		//service.updateGuest(g); //TODO: not necessary? deletes record from db

		//get all rests
		System.out.println(service.retrieveAllRest());

		//update rest
		r.setRestName("newRestName");
		//service.updateRestaurant(r); //TODO: not necessary? deletes record from db

		//delete guest
		service.deleteGuest(g4.getId());

		//delete rest
		service.deleteRestaurant(r4.getRestId());

		/*
		 * final database results
		 * 
		 * guest: 
		 * "1";"City";"newRestName";"restPhoneNumber";"zip"
		 * "2";"City";"restname";"restPhoneNumber";"zip"
		 * "3";"City";"restname";"restPhoneNumber";"zip"

		 * restaurant: 
		 * "1";"City";"newRestName";"restPhoneNumber";"zip"
		 * "2";"City";"restname";"restPhoneNumber";"zip"
         * "3";"City";"restname";"restPhoneNumber";"zip"
         
         *  

		 */
	}

}
