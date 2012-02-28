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

import com.octo.simplepfm.dao.BalanceDAO;
import com.octo.simplepfm.model.Balance;

@RequestMapping("/balances")
@Controller
public class BalancesController {
	@Autowired
	private BalanceDAO balancesDao;

	@RequestMapping(value = "/show/{accountId}")
	public ModelAndView showTransactions(@PathVariable String accountId, HttpServletRequest request, final HttpSession httpSession) {
		String customerId = (String) httpSession.getAttribute("customerId");
		if (customerId != null) {
			List<Balance> balanceList = balancesDao.getBalanceListForAccount(accountId, customerId);
			ModelMap map = new ModelMap();
			map.put("balances", balanceList);
			map.put("customerId", customerId);
			map.put("accountId", accountId);
			return new ModelAndView("balanceList", map);
 		} else {
 			throw new RuntimeException("Customer Id not present in session");
 		}
	}
}
