package com.mkyong.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private static final String LANDINGPAGE = "landing";
	private static final String LOGIN = "login";
	private static final String COMBINATION = "combination";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired 
	HttpServletRequest request;
	@Autowired 
	HttpServletResponse response;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return LOGIN;

	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
	public String loginCheck(ModelMap model,@RequestParam(value="usermail") String usermail, @RequestParam(value="password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		
		if("finra.es.test@gmail.com".equalsIgnoreCase(usermail) && "123456".equalsIgnoreCase(password)){
			response.addCookie(new Cookie("token", "AC23K4FGCC83CTHGHM9723D"));
			try {
				response.sendRedirect("landingPage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else {
			return LOGIN;
		}

	}
	
	@RequestMapping(value = "/landingPage", method = RequestMethod.GET)
	public String landing(ModelMap model,//@RequestParam(value="usermail") String usermail, @RequestParam(value="password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		
//		if("haoliu350@gmail.com".equalsIgnoreCase(usermail) && "123456".equalsIgnoreCase(password)){
//			response.addCookie(new Cookie("token", "usermail"));
//			return LANDINGPAGE;
//		}else {
//			return LOGIN;
//		}
		return LANDINGPAGE;

	}
	
	@RequestMapping(value = "/combination", method = RequestMethod.GET)
	public String getCombinations(@RequestParam(value="phoneNumber") String phoneNumber, ModelMap model) {

		model.addAttribute("phoneNumber", phoneNumber);
		return COMBINATION;
		
	}
	

}