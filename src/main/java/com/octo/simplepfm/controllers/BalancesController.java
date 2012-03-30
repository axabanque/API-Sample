package com.octo.simplepfm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.octo.simplepfm.dao.BalanceDAO;
import com.octo.simplepfm.model.Balance;

@RequestMapping("/customer/{customerId}/balances")
@Controller
public class BalancesController {
	@Autowired
	private BalanceDAO balancesDao;

	@RequestMapping(value = "/show/{accountId}")
	public String getBalances(@PathVariable String customerId, @PathVariable String accountId, Model model) {
		model.addAttribute("customerId", customerId);
		model.addAttribute("accountId", accountId);
		List<Balance> balanceList = balancesDao.getBalanceListForAccount(accountId, customerId);
		model.addAttribute("balances", Lists.reverse(balanceList));
		return "balanceList";
	}
}
