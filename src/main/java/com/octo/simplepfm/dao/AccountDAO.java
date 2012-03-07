package com.octo.simplepfm.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.octo.simplepfm.model.Account;
import com.octo.simplepfm.model.AccountSummary;
import com.octo.simplepfm.model.Balance;

@Repository
public class AccountDAO {
	
	private Logger logger  = Logger.getLogger(getClass());
	
	@Value("${base_url}")
	private String baseUrl;
	
	@Value("${client_id}")
	private String clientId;
	
	@Value("${access_token}")
	private String accessToken;
	
	@Autowired
	private BalanceDAO balanceDAO;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<AccountSummary> getAccountListForCustomer(String customerId) {
		AccountSummary [] accounts = restTemplate.getForObject(baseUrl +"/customers/{customerId}/accounts?client_id={clientId}&access_token={accessToken}&customer_id={customerId}", 
				AccountSummary[].class, 
				customerId, clientId, accessToken, customerId);
		logger.debug("CLIENT ID : " + clientId + " ACCESS TOKEN" + accessToken);
		List<AccountSummary> accountList = Arrays.asList(accounts);
		for (AccountSummary acc : accountList) {
			Balance b = balanceDAO.getBalanceForAccount(String.valueOf(acc.getAccount()), customerId);
			acc.setAmount(b.getAmount());
		}
		return accountList;
	}
	
	
	public Account getAccountById(String accountId,String customerId) {
		Account account = restTemplate.getForObject(baseUrl + "/accounts/{accountId}?client_id={clientId}&access_token={accessToken}&customer_id={customerId}",
				Account.class,
				accountId,clientId,accessToken, customerId);
		
		return account;
	}
	
}
