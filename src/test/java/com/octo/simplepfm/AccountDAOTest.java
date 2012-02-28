package com.octo.simplepfm;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.octo.simplepfm.dao.AccountDAO;
import com.octo.simplepfm.model.Account;
import com.octo.simplepfm.model.AccountSummary;

public class AccountDAOTest {
	
	private AccountDAO accountDao;
	
	@Before
	public void init() {
		accountDao = createStrictMock(AccountDAO.class);
	}
	
	
	@Test
	public void testGetOneAccountWithRestTemplate() {
		
		Account mock =  new Account();
		mock.setCurrency("EUR");
		mock.setCustomer(123456L);
		mock.setLabel("CC");
		expect(accountDao.getAccountById(eq("20000001500"), eq("1000000"))).andReturn(mock);
		replay(accountDao);
		Account account = accountDao.getAccountById("20000001500", "1000000");
		verify(accountDao);
		
		assertNotNull(account.getCurrency());
		assertNotNull(account.getCustomer());
		assertNotNull(account.getLabel());
	}
	
	@Test
	public void testGetListOfAccountWithRestTemplate() {
		String customerId = "1000000";
		List<AccountSummary> accountListMock = new ArrayList<AccountSummary>();
		AccountSummary mock1 = new AccountSummary();
		mock1.setAccount(12345L);
		mock1.setLabel("CC");
		AccountSummary mock2 = new AccountSummary();
		mock2.setAccount(12345L);
		mock2.setLabel("CC");
		accountListMock.add(mock1);
		accountListMock.add(mock2);
		expect(accountDao.getAccountListForCustomer(customerId)).andReturn(accountListMock);
		replay(accountDao);
		List<AccountSummary> accountList = accountDao.getAccountListForCustomer(customerId);
		verify(accountDao);
		assertTrue(accountList.size() > 0);
		for (AccountSummary summary : accountList) {
			assertNotNull(summary.getAccount());
			assertTrue(summary.getLabel().equals("CC"));
			assertNotNull(summary.getLabel());
		}
		
	}

}
