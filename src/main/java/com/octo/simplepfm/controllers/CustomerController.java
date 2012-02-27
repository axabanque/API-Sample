package com.octo.simplepfm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.octo.simplepfm.dao.AccountDAO;
import com.octo.simplepfm.form.ChooseCustomer;
import com.octo.simplepfm.model.AccountSummary;

@RequestMapping("/customer")
@SessionAttributes
@Controller
public class CustomerController {
	
		@Autowired
		private AccountDAO accountDao;
	
	 	@RequestMapping(value="/select", method=RequestMethod.GET)
	    public ModelAndView makeForm(Model model) {
	 		ChooseCustomer form = new ChooseCustomer();
	        ModelMap map = new ModelMap();
	        map.put("customerChoosed", form);
	        return new ModelAndView("customer",map);
	    }   
	 
	    @RequestMapping(value = "/customerAccounts", method = RequestMethod.POST)
	    public ModelAndView display(@ModelAttribute("choosecustomer") ChooseCustomer chooseCustomer, Model model, final HttpSession httpSession) {
	    	String customerId = chooseCustomer.getCustomerId();
	    	httpSession.setAttribute("customerId", customerId);
	    	List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId);
			ModelMap map = new ModelMap();
			map.put("accounts",accountList);
			map.put("customerId", customerId);
			return new ModelAndView("accountList",map);
	    }
}
