package com.octo.simplepfm.model;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Transaction {

	private Long id;

	private Long account;

	@JsonProperty(value = "type")
	private String transactionType;

	@JsonProperty(value = "date")
	private Date entryDate;

	@JsonProperty(value = "accounting_date")
	private Date accountingDate;

	private String label;

	private BigDecimal amount;

	private String currency;

	@JsonProperty(value = "transaction_date")
	private Date transactionDate;

	@JsonProperty("card_number")
	private String cardNumber;

	@JsonProperty(value = "card_type")
	private String cardType;

	private BigDecimal foreignAmount;

	private String foreignCurrency;

	private String entryType;

	private String cancellationType;

	private String internationalTransaction;


	public Transaction() {
	}

	public Transaction(String txType, String label, BigDecimal amount,
			String currency, Date date, Long account) {

		this.transactionType = txType;
		this.label = label;
		this.amount = amount;
		this.currency = currency;
		this.entryDate = this.accountingDate = date;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getAccount() {
		return account;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	protected String getResourceType() {
		return "entry";
	}

	public void setPublicId(Long id) {
		setId(id);
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

	public BigDecimal getForeignAmount() {
		return foreignAmount;
	}

	public void setForeignAmount(BigDecimal amount) {
		this.foreignAmount = amount;
	}

	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String currency) {
		this.foreignCurrency = currency;
	}

	public Date getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(Date date) {
		this.accountingDate = date;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getCancellationType() {
		return cancellationType;
	}

	public void setCancellationType(String cancellationType) {
		this.cancellationType = cancellationType;
	}

	public String getInternationalTransaction() {
		return internationalTransaction;
	}

	public void setInternationalTransaction(String internationalTransaction) {
		this.internationalTransaction = internationalTransaction;
	}


	public String getCardNumber() {
		return cardNumber;
	}

	public String geteCardType() {
		return cardType;
	}
}
