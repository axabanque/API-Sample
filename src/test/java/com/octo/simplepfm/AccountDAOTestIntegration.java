package com.octo.simplepfm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.octo.simplepfm.dao.AccountDAO;
import com.octo.simplepfm.dao.BalanceDAO;
import com.octo.simplepfm.model.Account;
import com.octo.simplepfm.model.AccountSummary;
import com.octo.simplepfm.model.Balance;

public class AccountDAOTestIntegration extends BaseSpringConfiguration {
	
	@Autowired
	private AccountDAO accountDao;
	
	@Autowired
	private BalanceDAO balancesDAO;
	
	@Test
	public void testGetOneAccountWithRestTemplate() {
		Account account = accountDao.getAccountById("20000001500", "1000000");
		assertNotNull(account.getCurrency());
		assertNotNull(account.getCustomer());
		assertNotNull(account.getLabel());
	}
	
	@Test
	public void testGetListOfAccountWithRestTemplate() {
		String customerId = "1000000";
		List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId);
		assertTrue(accountList.size() > 0);
		for (AccountSummary summary : accountList) {
			assertNotNull(summary.getAccount());
			assertNotNull(summary.getLabel());
		}
		
	}
	
	@Test
	public void testGetListOfAccountAndBalanceWithRestTemplate() {
		String customerId = "1000000";
		List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId);
		assertTrue(accountList.size() > 0);
		for (AccountSummary summary : accountList) {
			assertNotNull(summary.getAccount());
			assertNotNull(summary.getLabel());
			Balance b = balancesDAO.getBalanceForAccount(String.valueOf(summary.getAccount()), customerId);
			assertNotNull(b.getAmount());
		}
		
	}

}
