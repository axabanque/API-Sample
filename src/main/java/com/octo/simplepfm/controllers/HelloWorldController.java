package com.octo.simplepfm.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.simplepfm.services.HelloWordlService;

@Controller
public class HelloWorldController {
	
	@Autowired
	HelloWordlService helloWordlService;
	
	@RequestMapping("/helloWorld")
	protected String helloworld(Model model) {
		model.addAttribute("messageFromHelloWorld", helloWordlService.getData());
		return "helloWorld";
	}
}