package com.octo.simplepfm.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.helpers.SimplePfmConstant;
import com.octo.simplepfm.model.Balance;


@Repository
public class BalanceDAO {

	@Value("${base_url}")
	private String baseUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Balance getBalanceForAccount(String accountId,String customerId) {
		Balance balance;
		try {
			balance = restTemplate.getForObject(baseUrl + "/accounts/{accountId}/balance?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Balance.class,
				
				accountId,SimplePfmConstant.CLIENT_ID, SimplePfmConstant.ACCESS_TOKEN, customerId);
		} catch (HttpClientErrorException ex) {
			balance = new Balance();
			balance.setAmount(BigDecimal.ZERO);
		}
		return balance;
	}

	public List<Balance> getBalanceListForAccount(String accountId,
			String customerId) {
		Balance [] balances = restTemplate.getForObject(baseUrl + "/accounts/{accountId}/balances?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Balance[].class,
				accountId,SimplePfmConstant.CLIENT_ID, SimplePfmConstant.ACCESS_TOKEN, customerId);
		return Arrays.asList(balances);
	}
}
