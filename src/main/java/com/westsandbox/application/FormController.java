package com.westsandbox.application;

import javax.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.westsandbox.application.entities.Guest;
import com.westsandbox.application.entities.Restaurant;
import com.westsandbox.application.service.IRestaurantPickerService;

/**
 * Handles requests for the application home page.
 */
@Controller("/form")
public class FormController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	String formerRecordInd;
	
	@Autowired
	private IRestaurantPickerService service;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public String guestForm(Model model) {
        model.addAttribute("guest", new Guest());
        model.addAttribute("restaurant", new Restaurant());
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guestSubmit(@ModelAttribute Guest guest, @ModelAttribute Restaurant restaurant, Model model) {
    	service.addGuest(guest);
    	service.addRestaurant(restaurant);
    	service.mapRestToGuest(guest.getId(), restaurant.getRestId());
        model.addAttribute("guest", guest);
        model.addAttribute("restaurant", restaurant);
        return "form_result";
    }

}