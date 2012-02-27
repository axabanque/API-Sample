package com.octo.simplepfm.model;


public class IBAN {
	private String countryCode;
	private String bbanCode;
	private String key;
	private String bicCode;

	public IBAN() {
	}

	public IBAN(String countryCode, String bbanCode, String key, String bicCode) {
		this.countryCode = countryCode;
		this.bbanCode = bbanCode;
		this.key = key;
		this.bicCode = bicCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getBicCode() {
		return bicCode;
	}

	public String getBbanCode() {
		return bbanCode;
	}

	public String getKey() {
		return key;
	}
	
	public void setBbanCode(String bbanCode) {
		this.bbanCode = bbanCode;
	}
	
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
