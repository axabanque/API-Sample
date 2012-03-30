package com.octo.simplepfm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.simplepfm.dao.AccountDAO;
import com.octo.simplepfm.model.AccountSummary;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	private final String[] customers = { "1000000", "1000001", "1000002", "1500000" };

	@Autowired
	private AccountDAO accountDao;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(Model model) {
		model.addAttribute("customers", customers);
		return "customer";
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
	public String display(@PathVariable String customerId, Model model) {
		model.addAttribute("customerId", customerId);
		List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId);
		model.addAttribute("accounts", accountList);
		return "accountList";
	}
}
