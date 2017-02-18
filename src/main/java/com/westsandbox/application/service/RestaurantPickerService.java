package com.westsandbox.application.service;

import java.util.List;
import java.util.Random;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.springframework.transaction.annotation.Transactional;

import com.westsandbox.application.dao.IRestaurantPickerDAO;
import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;

@Transactional
public class RestaurantPickerService implements IRestaurantPickerService {

	private IRestaurantPickerDAO dao;


	public IRestaurantPickerDAO getDao() {
		return dao;
	}

	public void setDao(IRestaurantPickerDAO dao) {
		this.dao = dao;
	}

	@Override
	public Guest addGuest(Guest g) {
		// TODO Auto-generated method stub
		return dao.addGuest(g);
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		return dao.addRestaurant(r);
	}

	@Override
	public void mapRestToGuest(int guestId, int restId) {
		// TODO Auto-generated method stub
		dao.mapRestToGuest(guestId, restId);
	}

	@Override
	public List<Restaurant> retrieveAllRest() {
		// TODO Auto-generated method stub
		return dao.retrieveAllRest();
	}

	@Override
	public void deleteRestaurant(int restId) {
		// TODO Auto-generated method stub
		dao.deleteRestaurant(restId);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		return dao.updateRestaurant(r);
	}

	@Override
	public List<Guest> retrieveAllGuests() {
		// TODO Auto-generated method stub
		return dao.retrieveAllGuests();
	}

	@Override
	public void deleteGuest(int guestId) {
		// TODO Auto-generated method stub
		dao.deleteGuest(guestId);
	}

	@Override
	public Guest updateGuest(Guest g) {
		// TODO Auto-generated method stub
		return dao.updateGuest(g);
	}

	@Override
	public Restaurant pickRestaurant() {
		// TODO Auto-generated method stub
		List<Restaurant> allRests = dao.retrieveAllRest();
		if(allRests.size()==0){
			return null;
		}
		//generate random index
		int restIdx = (new Random()).nextInt(allRests.size());
		//send email to guests
		int numGuests = dao.retrieveAllGuests().size();
		for(int i=0; i<numGuests; i++)
			//TODO: SocketException: Permission denied: connect
			//sendEmailToGuest();
			;
		//return that index from the list
		return allRests.get(restIdx);
	}

	@Override
	public void sendEmailToGuest() {
		// Recipient's email ID needs to be mentioned.
		String to = "mike.b.albanese@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "Restaurant.Picker@capitalone.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Send the actual HTML message, as big as you like
			message.setContent("<h1>This is actual message</h1>", "text/html" );

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
