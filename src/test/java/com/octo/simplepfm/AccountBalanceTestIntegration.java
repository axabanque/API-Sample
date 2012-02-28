package com.octo.simplepfm;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.octo.simplepfm.dao.BalanceDAO;
import com.octo.simplepfm.model.Balance;

public class AccountBalanceTestIntegration extends BaseSpringConfiguration {
	
	
	@Autowired
	private BalanceDAO balancesDAO;
	
	
	@Test
	public void getBalanceForAccount() {
		String customerId = "1000000";
		String accountId  = "20000001500";
		Balance balance = balancesDAO.getBalanceForAccount(accountId, customerId);
		assertNotNull(balance.getAccount());
		assertNotNull(balance.getAmount());
		assertNotNull(balance.getCurrency());
	}
	
	@Test
	public void getBalanceListForAccount() {
		String customerId = "1000000";
		String accountId  = "20000001500";
		List<Balance> balances = balancesDAO.getBalanceListForAccount(accountId, customerId);
		for (Balance b : balances) {
			assertNotNull(b.getDate());
			assertNotNull(b.getAccount());
			assertNotNull(b.getAmount());
			assertNotNull(b.getCurrency());
		}
	}

}
