package com.octo.simplepfm.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.helpers.SimplePfmConstant;
import com.octo.simplepfm.model.Account;
import com.octo.simplepfm.model.AccountSummary;

@Repository
public class AccountDAO {
	@Value("${base_url}")
	private String baseUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<AccountSummary> getAccountListForCustomer(String customerId) {
		AccountSummary [] accounts = restTemplate.getForObject(baseUrl +"/customers/{customerId}/accounts?client_id={clientId}&access_token={accessToken}&customer_id={customerId}", 
				AccountSummary[].class, 
				customerId, SimplePfmConstant.CLIENT_ID, SimplePfmConstant.ACCESS_TOKEN, customerId);
		
		return Arrays.asList(accounts);
	}
	
	
	public Account getAccountById(String accountId,String customerId) {
		Account account = restTemplate.getForObject(baseUrl + "/accounts/{accountId}?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Account.class,
				accountId,SimplePfmConstant.CLIENT_ID, SimplePfmConstant.ACCESS_TOKEN, customerId);
		
		return account;
	}
	
}
