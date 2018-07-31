package hu.vr.representable.example.model;

import java.util.HashSet;
import java.util.Set;

public class DirectlySecuredLoan {
	private final String creditContractNr;
	private final String accountId;
	private final String accountCcy;
	
	private String loanName;
	private double limit;
	private double riskValue;
	private double coveredAmt;
	
	private final Set<Collateral> collaterals = new HashSet<>();
	
	public DirectlySecuredLoan(String creditContractNr, String accountId, String accountCcy) {
		super();
		this.creditContractNr = creditContractNr;
		this.accountId = accountId;
		this.accountCcy = accountCcy;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public String getLimit() {
		return ""+(long)limit+" "+getAccountCcy();
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public String getRiskValue() {
		return ""+(long)riskValue+" "+getAccountCcy();
	}

	public void setRiskValue(double riskValue) {
		this.riskValue = riskValue;
	}

	public String getCoveredAmt() {
		return ""+(long)coveredAmt+" "+getAccountCcy();
	}

	public void setCoveredAmt(double coveredAmt) {
		this.coveredAmt = coveredAmt;
	}

	public String getCreditContractNr() {
		return creditContractNr;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getAccountCcy() {
		return accountCcy;
	}

	public Set<Collateral> getCollaterals() {
		return collaterals;
	}

}
