package com.octo.simplepfm.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.octo.simplepfm.dao.TransactionDAO;
import com.octo.simplepfm.model.Transaction;

@RequestMapping("/accounts")
@Controller
public class AccountController {

	@Autowired
	private TransactionDAO transactionDao;

	@RequestMapping(value = "/show/{accountId}")
	public ModelAndView showTransactions(@PathVariable String accountId, HttpServletRequest request, final HttpSession httpSession) {
		String customerId = (String) httpSession.getAttribute("customerId");
		if (customerId != null) {
			List<Transaction> transactionList = transactionDao.getTransactionList(accountId, customerId);
			System.out.println("Customer Id : " + customerId);
			ModelMap map = new ModelMap();
			map.put("transactions", transactionList);
			map.put("accountId", accountId);
			return new ModelAndView("transactionList", map);
 		} else {
 			throw new RuntimeException("Customer Id not present in session");
 		}
	}
}
