package com.octo.simplepfm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.helpers.SimplePfmConstant;
import com.octo.simplepfm.model.AccountSummary;
import com.octo.simplepfm.model.Transaction;

@Repository
public class TransactionDAO {
	
	@Value("${base_url}")
	private String baseUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<Transaction> getTransactionList(String accountId, String customerId, String sinceId) {
		Transaction [] transactions = restTemplate.getForObject(baseUrl 
				+ "accounts/{accountId}/transactions?client_id={clientId}&access_token={accessToken}&since_id={sinceId}&customer_id={customerId}", 
				Transaction[].class, accountId,SimplePfmConstant.CLIENT_ID, SimplePfmConstant.ACCESS_TOKEN, sinceId, customerId);	
		return Arrays.asList(transactions);
	}

}
