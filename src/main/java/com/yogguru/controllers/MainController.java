package com.yogguru.controllers;

import java.io.File;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.dao.MainDao;
import com.yogguru.model.GuruModel;

@Controller
public class MainController {

	@Autowired
	private MainDao mainDao;

	@RequestMapping(path = { "/", "/index" })
	public String getHome() {
		return "index";
	}
	
	@RequestMapping("/Faq")
	public String getFaqs() {
		return "faq";
	}

	@RequestMapping("/GuruRegistration")
	public String getMainResgistration() {

		return "guruRegistration";
	}

	@RequestMapping(path = "/login")
	public String getLogin(Model model, HttpServletRequest req, HttpSession ss) {
		if (ss.getAttribute("guruId") != null) {
			return "redirect:/Guru";
		} else {
			System.out.println("req msg" + req.getParameter("msg"));

			model.addAttribute("msg", req.getParameter("msg"));
			System.out.println("model msg " + model.getAttribute("msg"));
			return "login";
		}
	}

	@RequestMapping("/GuruRegisterSuccess")
	public String guruRegistrationSuccess() {
		return "guruRegistrationSuccess";
	}

	@RequestMapping(path = { "/RegisterGuru" }, method = RequestMethod.POST)
	public String registerGuru(@ModelAttribute GuruModel model,
			@RequestParam("profile_photo") CommonsMultipartFile file, HttpSession ss) {
		String path = ss.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
				+ File.separator + "profile_photo";

		// add the image to server
		String finalName = this.mainDao.addGuruProfileImage(file, model, path, file.getContentType());
		// System.out.println(model);
		// System.out.println(finalName);
		// now add the guru
		boolean flag = this.mainDao.addGuru(model, finalName);
		System.out.println(flag);
		return "redirect:/GuruRegisterSuccess";
	}

	@RequestMapping("/confirmGuruEmail")
	public String validateGuruEmail(@RequestParam("id") String id) {

		boolean flag = this.mainDao.checkGuruEmailValidation(id);
		System.out.println(flag);
		if (flag) {
			return "guruRegistEmailValidSucc";
		} else {
			return "guruRegistEmailValidError";
		}
	}

	@RequestMapping("checkForUniqueGuruEmail")
	@ResponseBody
	public String checkForUniqueGuruEmail(@RequestParam("email") String email) {
		boolean flag = false;
		flag = this.mainDao.checkThisEmailAlreadyExist(email);

		if (flag) {
			return "no";
		} else {
			return "yes";
		}
	}

	@RequestMapping("/loginCheck")
	public String login(@ModelAttribute GuruModel guru, Model model, HttpSession sess) {
		boolean flag = this.mainDao.checkLoginCredential(guru);

		if (flag) {
			flag = this.mainDao.isAccountValidated(guru);

			if (flag) {
				sess.setAttribute("guruId", this.mainDao.getGuruId(guru));
				return "redirect:/Guru";
			} else {
				model.addAttribute("msg", "Please First Complete The Validation Process");
				return "redirect:/login";
			}
		} else {
			model.addAttribute("msg", "This Account does not exist");
			return "redirect:/login";
		}

	}

	@RequestMapping("/LogOut")
	public String logOut(HttpSession ss) {
		if (ss.getAttribute("guruId") != null) {
			ss.removeAttribute("guruId");
		}

		return "redirect:/";
	}

}
