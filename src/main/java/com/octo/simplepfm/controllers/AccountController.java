package com.octo.simplepfm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.simplepfm.dao.TransactionDAO;
import com.octo.simplepfm.model.Transaction;

@RequestMapping("/customer/{customerId}/accounts")
@Controller
public class AccountController {

	@Autowired
	private TransactionDAO transactionDao;

	@RequestMapping(value = "/show/{accountId}/page/{page}")
	public String showTransactions(@PathVariable String customerId, @PathVariable String accountId, @PathVariable String page, Model model) {
		model.addAttribute("customerId", customerId);
		model.addAttribute("accountId", accountId);
		model.addAttribute("page", page);
		List<Transaction> transactionList = transactionDao.getTransactionList(accountId, customerId, page);
		model.addAttribute("transactions", transactionList);
		return "transactionList";
	}
}
