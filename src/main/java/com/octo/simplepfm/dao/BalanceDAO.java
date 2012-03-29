package com.octo.simplepfm.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.model.Balance;


@Repository
public class BalanceDAO {
	
	private Logger logger  = Logger.getLogger(getClass());

	@Value("${base_url}")
	private String baseUrl;
	
	@Value("${client_id}")
	private String clientId;
	
	@Value("${access_token}")
	private String accessToken;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Balance getBalanceForAccount(String accountId,String customerId) {
		Balance balance;
		try {
			balance = restTemplate.getForObject(baseUrl + "/accounts/{accountId}/balance?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Balance.class,
				
				accountId,clientId, accessToken, customerId);
		} catch (HttpClientErrorException ex) {
			balance = new Balance();
			balance.setAmount(BigDecimal.ZERO);
			logger.error("API Didn't give any balance for account " + accountId + " because : " + ex.getMessage());
			logger.error("clientID :" + clientId + " accesstoken : " + accessToken);
		}
		return balance;
	}

	public List<Balance> getBalanceListForAccount(String accountId,
			String customerId) {
		Balance [] balances = restTemplate.getForObject(baseUrl + "/accounts/{accountId}/balances?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Balance[].class,
				accountId,clientId, accessToken, customerId);
		return Arrays.asList(balances);
	}
}
