package com.octo.simplepfm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.dao.AccountDAO;
import com.octo.simplepfm.model.Account;
import com.octo.simplepfm.model.AccountSummary;

public class AccountDAOTest extends BaseSpringConfiguration {
	
	@Autowired
	private AccountDAO accountDao;
	
	
	@Test
	public void testGetOneAccountWithRestTemplate() {
		Account account = accountDao.getAccountById("20000001500", "2000300", "1000000");
		assertNotNull(account.getCurrency());
		assertNotNull(account.getCustomer());
		assertNotNull(account.getLabel());
	}
	
	@Test
	public void testGetListOfAccountWithRestTemplate() {
		RestTemplate template = new RestTemplate();
		String customerId = "1000000";
		List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId, "2000300");
		assertTrue(accountList.size() > 0);
		for (AccountSummary summary : accountList) {
			assertNotNull(summary.getAccount());
			assertNotNull(summary.getLabel());
		}
		
	}

}
