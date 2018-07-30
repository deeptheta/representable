package org.user.renderer;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.user.elements.CollateralAssetSheet;
import org.user.elements.DSLFull;
import org.user.model.Collateral;
import org.user.model.DirectlySecuredLoan;
import org.user.system.CollateralManagement;

import hu.vr.representable.factory.RepresentableFactory;
import hu.vr.representable.html.elements.InputButton;

public class RepresentableFactoryTest {
	
	private final RepresentableFactory reprMapping = new RepresentableFactory();
	private final AdvancedRenderer advRenderer = new AdvancedRenderer(reprMapping);
	
	/**
	 * Ideally, the representation mapping initialization will be done
	 * by annotations (e.g. @Represents(...) or @RepresentedBy(...)) in the future.
	 */
	@Before
	public void initTest() {
		reprMapping.getFactoryMethods().put(String.class, x -> new InputButton(String.class.cast(x)));
		reprMapping.getFactoryMethods().put(Collateral.class, x -> new CollateralAssetSheet(Collateral.class.cast(x)));
		reprMapping.getFactoryMethods().put(DirectlySecuredLoan.class, x -> new DSLFull(DirectlySecuredLoan.class.cast(x)));
	}
	
	@Test
	public void representString() {
		Object someObject = "Colorless green ideas sleep furiously.";
		String result = advRenderer.render(someObject);
        System.out.println("String as Obj.:    " + result);
                
        assertTrue( result.startsWith("<input ") );
        assertTrue( result.substring(6, 67).contains(" type=\"button\"") );
        assertTrue( result.substring(6, 67).contains(" value=\"Colorless green ideas sleep furiously.\"") );
        assertTrue( result.endsWith("/>") );
	}
	
	@Test
	public void representCollateral() {
		Object someObject = CollateralManagement.COLLATERAL04;
		String result = advRenderer.render(someObject);
        System.out.println("Collateral Obj:    " + result);
        
        assertTrue( ("<table style=\"border: solid black 1px;\">"
        		+ "<tr><td>Collateral ID</td><td>20170223BCR_04_00012345</td></tr>"
        		+ "<tr><td>Allocated value</td><td>2118 RON</td></tr>"
        		+ "<tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr>"
        		+ "<tr><td>Asset valuation rate</td><td>75 %</td></tr>"
        		+ "<tr><td>Base value of asset</td><td>4111367 RON</td></tr>"
        		+ "<tr><td>Acceptable value</td><td>3083525 RON</td></tr>"
        		+ "</table>").equals(result) );
	}
	
	@Test
	public void representDSL() {
		Object someObject = CollateralManagement.DSL01;
		String result = advRenderer.render(someObject);
        System.out.println("DSL as Object :    " + result);
        
        assertTrue( ("<div style=\"background-color: lightblue; width: 500px; margin: 20px;\">Directly Secured Loan<table><tr><td>Credit contract nr</td><td>1056201613067</td></tr><tr><td>Account ID</td><td>Romania_BCR___000074169</td></tr><tr><td>Loan name</td><td>SELTESTLOAN01</td></tr><tr><td>Limit</td><td>9737 RON</td></tr><tr><td>Risk value</td><td>9737 RON</td></tr><tr><td>Covered amount</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_01_00012345</td></tr><tr><td>Allocated value</td><td>5 RON</td></tr><tr><td>Backing asset</td><td>988 - 988 - 2.3.1. Standard production machinery</td></tr><tr><td>Asset valuation rate</td><td>50 %</td></tr><tr><td>Base value of asset</td><td>10 RON</td></tr><tr><td>Acceptable value</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_02_00012345</td></tr><tr><td>Allocated value</td><td>0 RON</td></tr><tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr><tr><td>Asset valuation rate</td><td>75 %</td></tr><tr><td>Base value of asset</td><td>0 RON</td></tr><tr><td>Acceptable value</td><td>0 RON</td></tr></table></div>")
        		.equals(result) );
	}

}
