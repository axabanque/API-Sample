package com.octo.simplepfm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.helpers.SimplePfmConstant;
import com.octo.simplepfm.model.Transaction;

@Repository
public class TransactionDAO {
	
	@Value("${base_url}")
	private String baseUrl;
	
	@Value("${client_id}")
	private String clientId;
	
	@Value("${access_token}")
	private String accessToken;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<Transaction> getTransactionList(String accountId, String customerId, String page) {
		Transaction [] transactions = restTemplate.getForObject(baseUrl 
				+ "/accounts/{accountId}/transactions?client_id={clientId}&access_token={accessToken}&customer_id={customerId}&count={count}&page={page}", 
				Transaction[].class, accountId,clientId, accessToken, customerId, SimplePfmConstant.PAGE_SIZE, page);	
		return Arrays.asList(transactions);
	}

}
