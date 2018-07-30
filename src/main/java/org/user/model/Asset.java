package org.user.model;

public class Asset {
	private final String description;
	private String currency;
	private double baseValue;
	private double valuationRate;
	
	public Asset(String description, String currency, double baseValue, double valuationRate) {
		super();
		this.description = description;
		this.currency = currency;
		this.baseValue = baseValue;
		this.valuationRate = valuationRate;
	}

	public String getValuationRate() {
		return ""+(int)(valuationRate*100)+" %";
	}

	public void setValuationRate(double valuationRate) {
		if(valuationRate>=0 && valuationRate<=1) {	// TODO check floating point arithmetic
			this.valuationRate = valuationRate;
		}
		else {
			throw new IllegalArgumentException("Invalid valuation rate: " + valuationRate);
		}
		
	}

	public String getBaseValue() {
		return ""+(long)baseValue+" "+getCurrency();
	}

	public void setBaseValue(double baseValue) {
		this.baseValue = baseValue;
	}

	public String getAcceptableValue() {
		return ""+(long)(baseValue*valuationRate)+" "+getCurrency();
	}

	public String getDescription() {
		return description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
