package org.user.system;

import org.user.model.Asset;
import org.user.model.Collateral;
import org.user.model.DirectlySecuredLoan;

public class CollateralManagement {
	public static final Asset ASSET01 = new Asset("988 - 988 - 2.3.1. Standard production machinery", "RON", 10.1, 0.5);
	public static final Asset ASSET02 = new Asset("848 - 848 - 4.3. Gold", "RON", 0.0, 0.75);
	public static final Asset ASSET03 = new Asset("848 - 848 - 4.3. Gold", "RON", 4111367.78, 0.75);
	
	public static final Collateral COLLATERAL01 = new Collateral("20170223BCR_01", ASSET01, "RON", 5.0);
	public static final Collateral COLLATERAL02 = new Collateral("20170223BCR_02", ASSET02, "RON", 0.0);
	public static final Collateral COLLATERAL03 = new Collateral("20170425BCR_03", ASSET03, "RON", 0.0);
	public static final Collateral COLLATERAL04 = new Collateral("20170223BCR_04", ASSET03, "RON", 2118.0);
	
	public static final DirectlySecuredLoan DSL01 = new DirectlySecuredLoan("1056201613067", "Romania_BCR___000074169", "RON");
	public static final DirectlySecuredLoan DSL02 = new DirectlySecuredLoan(null, "Romania_BCR___000092343", "EUR");
	public static final DirectlySecuredLoan DSL03 = new DirectlySecuredLoan("191384497449", "Romania_BCR___000074164", "RON");
	
	static {
		DSL01.setLoanName("SELTESTLOAN01");
		DSL01.setLimit(9737.0);
		DSL01.setRiskValue(9737.0);
		DSL01.setCoveredAmt(5.0);
		DSL01.getCollaterals().add(COLLATERAL01);
		DSL01.getCollaterals().add(COLLATERAL02);
		
		DSL02.setLoanName("NEW LOAN");
		DSL02.setLimit(30000);
		DSL02.setRiskValue(30000);
		DSL02.getCollaterals().add(COLLATERAL03);
		
		DSL03.setLoanName("SELTESTLOAN01");
		DSL03.setLimit(2118.0);
		DSL03.setRiskValue(2118.0);
		DSL03.setCoveredAmt(2118.0);
		DSL03.getCollaterals().add(COLLATERAL04);
	}

}
