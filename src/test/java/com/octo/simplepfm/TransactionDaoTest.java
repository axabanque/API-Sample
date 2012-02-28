package com.octo.simplepfm;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;
import static org.easymock.EasyMock.expect;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.octo.simplepfm.dao.TransactionDAO;
import com.octo.simplepfm.model.Transaction;

public class TransactionDaoTest {
	
	private TransactionDAO transactionDao;
	
	@Before
	public void init() {
		transactionDao = createStrictMock(TransactionDAO.class);
	}
	
	@Test
	public void testTransactionListOk() {
		final String accountId = "20000001500";
		final String customerId= "1000000";
		List<Transaction> transactionListMock = Lists.newArrayList();
		transactionListMock.add(new Transaction());
		transactionListMock.add(new Transaction());
		transactionListMock.add(new Transaction());
		Function<Transaction, Transaction> setLabelFunction = new Function<Transaction, Transaction>() {
            @Override
            public Transaction apply(Transaction o) {
                if (o == null) {
                    return null;
                }
                Transaction toinit = (Transaction) o;
                toinit.setLabel("virement");
                return toinit;
            }
        };
        List<Transaction> buildList = Lists.transform(transactionListMock, setLabelFunction);
        
        
        expect(transactionDao.getTransactionList(accountId, customerId, "1")).andReturn(buildList);
        replay(transactionDao);
		List<Transaction> transactionList = transactionDao.getTransactionList(accountId,customerId, "1");
		verify(transactionDao);
		
		assertTrue(transactionList.size() == 3);
		for (Transaction t : transactionList) {
			assertTrue(t.getLabel().equals("virement"));
		}
		
	}
}
