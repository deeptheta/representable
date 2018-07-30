package org.user.model;

public class Collateral {
	private final String uniqueId;
	private final Asset asset;
	private final String currency;
	private double allocatedVal;
	
	
	
	public Collateral(String uniqueIdPrefix, Asset asset, String currency, double allocatedVal) {
		super();
		this.uniqueId = uniqueIdPrefix + "_" + "00012345";// simplified for testing, TODO in reality: String.format("%08d", UUID.randomUUID().getMostSignificantBits()%100000000);
		this.asset = asset;
		this.currency = currency;
		this.allocatedVal = allocatedVal;
	}

	public String getAllocatedVal() {
		return ""+(long)allocatedVal+" "+getCurrency();
	}

	public void setAllocatedVal(double allocatedVal) {
		this.allocatedVal = allocatedVal;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public String getCurrency() {
		return currency;
	}

	public Asset getAsset() {
		return asset;
	}

}
