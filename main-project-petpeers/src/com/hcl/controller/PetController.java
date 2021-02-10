package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.pojo.User;
import com.hcl.pojo.Pet;
import com.hcl.service.PetService;

@Controller
public class PetController {
	@Autowired
	PetService petService;
	
	@RequestMapping("/registerpet")
	public String getPetRegisterPage(Model model,HttpServletResponse response) {
		Pet pet = new Pet();
		model.addAttribute("pet", pet);	
		return "registerpet";
	}
	@RequestMapping("/processregisterpet")
	public String register( @ModelAttribute("pet") Pet pet, 
			RedirectAttributes redirectAttributes, Model model,HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("validUser");
		
		String message = petService.addPet(pet, user);
		if (message.equals("Sucessfully Registered")) {
			
			
			System.out.println("registerd successfully");
			return "profile";
		
		} else {
			model.addAttribute("message", "not registered");
			return "registerpet";
		}


}
	@RequestMapping("/displaypets")
	public String getMyPets(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session =  request.getSession(true);
		User user = (User) session.getAttribute("validUser");
		System.out.println(user.getName());
		List<Pet> myPets = petService.displayPets(user);

		System.out.println("Pet Details"  + myPets.size() );
		for(Pet pet: myPets) {
			System.out.println( pet.getPetbreed() + "--");
		}
		model.addAttribute("myPets", myPets);
		
		return "displaypets";
		
	}
	
	@RequestMapping("/profile")
	public String backToProfile(HttpServletResponse response) {
		
		return "profile";
	}
	
}
