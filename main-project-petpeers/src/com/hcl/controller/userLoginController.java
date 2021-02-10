package com.hcl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hcl.pojo.User;
import com.hcl.service.LoginService;
import com.hcl.service.RegisterService;

@Controller
public class userLoginController {

	@Autowired
	RegisterService RegisterServiceImpl;
	@Autowired
	LoginService loginServiceImpl;

	@RequestMapping("/login")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping("/register")
	public String getRegisterPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value = "/processregister", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("message", "Details must be proper");
			System.out.println("Wrongly Registered ");
			return "register";
		} else {
			String message = RegisterServiceImpl.RegisterUserDetails(user);
			if (message.equals("Registered Sucessfully")) {
				redirectAttributes.addFlashAttribute("message", "Sucessfully Registered");
				System.out.println("Registered Successfully!");
				return "redirect:/login";

			} else {
				model.addAttribute("message", "User already exsists Please login");
				return "register";
			}

		}
	}

	@RequestMapping(value = "/processlogin", method = RequestMethod.POST)
	public String getProfilepage(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request, Model model) {

		User validUser = loginServiceImpl.validateLogin(user);
		if (validUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("validUser", validUser);
			model.addAttribute("validUser", session.getAttribute("validUser"));

			return "profile";
		}

		model.addAttribute("message", "invalid credentials");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		session.invalidate();
		model.addAttribute("validUser", null);
		redirectAttributes.addFlashAttribute("message", "Thank you for using our app! You are sucessfully logged out");

		return "redirect:/";
	}

	@RequestMapping("/")
	public String homePage() {

		return "home";
	}

}
