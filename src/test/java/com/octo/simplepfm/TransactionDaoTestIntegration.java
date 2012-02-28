package com.octo.simplepfm;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.octo.simplepfm.dao.TransactionDAO;
import com.octo.simplepfm.model.Transaction;

public class TransactionDaoTestIntegration extends BaseSpringConfiguration {
	
	@Autowired
	private TransactionDAO transactionDao;
	
	@Test
	public void testTransactionListOk() {
		final String accountId = "20000001500";
		final String customerId= "1000000";
		List<Transaction> transactionList = transactionDao.getTransactionList(accountId,customerId, "1");
		assertTrue(transactionList.size() > 0);
		for (Transaction t : transactionList) {
			System.out.println(t.getLabel());
		}
		
	}
}
