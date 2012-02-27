package com.octo.simplepfm.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutstandingTransactionEntity { 

	private String label;
	private BigDecimal amount;
	private String currency;
	private Date date;

	private Account account;

	public OutstandingTransactionEntity() {
	}

	public OutstandingTransactionEntity(String label, BigDecimal amount, String currency, Date date, Account account) {
//		setId(MockData.getNextValue());
		this.label = label;
		this.amount = amount;
		this.currency = currency;
		this.date = date;
		this.account = account;
	}

	protected String getResourceType() {
		return "transaction";
	}


	public void setPublicId(Long id) {
		// publicId mapped to id
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}
	

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
