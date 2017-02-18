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

@Controller("/picker")
public class PickerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IRestaurantPickerService service;
	
	@RequestMapping(value="/picker", method=RequestMethod.GET)
    public String pickerForm(@ModelAttribute Guest guest, @ModelAttribute Restaurant restaurant, Model model) {
        return "picker";
    }
    
    @RequestMapping(value="/picker", method=RequestMethod.POST)
    public String pickerSubmit(@ModelAttribute Guest guest, @ModelAttribute Restaurant restaurant, Model model) {
    	restaurant = service.pickRestaurant();
    	model.addAttribute("restaurant", restaurant);
    	if(restaurant == null){
    		model.addAttribute("error", "There are no restaurants in the database! (Hint: feed me data.)");
    		return "picker_error";
    	}
        return "picker_result";
    }

}
