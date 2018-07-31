package org.user.renderer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.user.elements.DSLFull;
import org.user.elements.DSLShallow;
import org.user.elements.SummaryPage;
import org.user.system.CollateralManagement;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.html.elements.Label;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class AdvancedRendererTest {
	
	private AdvancedRenderer advRenderer = new AdvancedRenderer();
	
	@Test
    public void renderSimpleObject() {
        Object o = new Object();
        String result = advRenderer.render(o);
        System.out.println("simple object :    " + result);
        
        assertTrue( result.startsWith("java.lang.Object@") );
    }
	
	@Test
    public void renderOtherComposed() {
		AbstractHtmlContainer otherCont = new AbstractHtmlContainer() {
			@Override public HtmlContainerTag getTag() { return HtmlContainerTag.DomainElement.a; }
			@Override public TextContent getContent() { return TextContent.text("click here"); }
			@Override public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() { return null; }
			@Override
			public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
				List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
				children.add(new Label("</br>or here"));
				return children;
			}
		};
        String result = advRenderer.render(otherCont);
        System.out.println("other composed:    " + result);
        
        assertTrue( "<a>click here&lt;/br&gt;or here</a>".equals(result) );
    }
	
	@Test
    public void renderDSLShallow() {
        DSLShallow dsl = new DSLShallow(CollateralManagement.DSL01);
        String result = advRenderer.render(dsl);
        System.out.println("dsl shallow   :    " + result);
        
        assertTrue( ("<div style=\"background-color:lightblue;\">Directly Secured Loan<table>"
        		+ "<tr><td>Credit contract nr</td><td>1056201613067</td></tr>"
        		+ "<tr><td>Account ID</td><td>Romania_BCR___000074169</td></tr>"
        		+ "<tr><td>Loan name</td><td>SELTESTLOAN01</td></tr>"
        		+ "<tr><td>Limit</td><td>9737 RON</td></tr>"
        		+ "<tr><td>Risk value</td><td>9737 RON</td></tr>"
        		+ "<tr><td>Covered amount</td><td>5 RON</td></tr></table></div>").equals(result) );
    }

	@Test
    public void renderDSL() {
        DSLFull dsl = new DSLFull(CollateralManagement.DSL01);
        String result = advRenderer.render(dsl);
        System.out.println("dsl full      :    " + result);
        
        assertTrue( ("<div style=\"background-color: lightblue; width: 500px; margin: 20px;\">Directly Secured Loan<table><tr><td>Credit contract nr</td><td>1056201613067</td></tr><tr><td>Account ID</td><td>Romania_BCR___000074169</td></tr><tr><td>Loan name</td><td>SELTESTLOAN01</td></tr><tr><td>Limit</td><td>9737 RON</td></tr><tr><td>Risk value</td><td>9737 RON</td></tr><tr><td>Covered amount</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_01_00012345</td></tr><tr><td>Allocated value</td><td>5 RON</td></tr><tr><td>Backing asset</td><td>988 - 988 - 2.3.1. Standard production machinery</td></tr><tr><td>Asset valuation rate</td><td>50 %</td></tr><tr><td>Base value of asset</td><td>10 RON</td></tr><tr><td>Acceptable value</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_02_00012345</td></tr><tr><td>Allocated value</td><td>0 RON</td></tr><tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr><tr><td>Asset valuation rate</td><td>75 %</td></tr><tr><td>Base value of asset</td><td>0 RON</td></tr><tr><td>Acceptable value</td><td>0 RON</td></tr></table></div>")
        		.equals(result) );
    }
	
	@Test
    public void renderSummary() {
		SummaryPage sumPage = new SummaryPage();
		sumPage.addDSL(CollateralManagement.DSL01);
		sumPage.addDSL(CollateralManagement.DSL02);
		sumPage.addDSL(CollateralManagement.DSL03);
        String result = advRenderer.render(sumPage);
        System.out.println("summary page  :    " + result);
        
        assertTrue( result.startsWith("<div>Summary Page | Search: <input ") );
        assertTrue( result.substring(34, 55).contains(" type=\"text\"") );
        assertTrue( result.substring(34, 55).contains(" value=\"\"") );
        assertTrue( result.substring(55, 64).contains("/><input ") );
        assertTrue( result.substring(63, 90).contains(" type=\"button\"") );
        assertTrue( result.substring(63, 90).contains(" value=\"Find\"") );
        assertTrue( result.endsWith("/><br/><div style=\"display: flex; flex-wrap: wrap; \"><div style=\"background-color: lightblue; width: 500px; margin: 20px;\">Directly Secured Loan<table><tr><td>Credit contract nr</td><td>1056201613067</td></tr><tr><td>Account ID</td><td>Romania_BCR___000074169</td></tr><tr><td>Loan name</td><td>SELTESTLOAN01</td></tr><tr><td>Limit</td><td>9737 RON</td></tr><tr><td>Risk value</td><td>9737 RON</td></tr><tr><td>Covered amount</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_01_00012345</td></tr><tr><td>Allocated value</td><td>5 RON</td></tr><tr><td>Backing asset</td><td>988 - 988 - 2.3.1. Standard production machinery</td></tr><tr><td>Asset valuation rate</td><td>50 %</td></tr><tr><td>Base value of asset</td><td>10 RON</td></tr><tr><td>Acceptable value</td><td>5 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_02_00012345</td></tr><tr><td>Allocated value</td><td>0 RON</td></tr><tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr><tr><td>Asset valuation rate</td><td>75 %</td></tr><tr><td>Base value of asset</td><td>0 RON</td></tr><tr><td>Acceptable value</td><td>0 RON</td></tr></table></div><div style=\"background-color: lightblue; width: 500px; margin: 20px;\">Directly Secured Loan<table><tr><td>Credit contract nr</td><td></td></tr><tr><td>Account ID</td><td>Romania_BCR___000092343</td></tr><tr><td>Loan name</td><td>NEW LOAN</td></tr><tr><td>Limit</td><td>30000 EUR</td></tr><tr><td>Risk value</td><td>30000 EUR</td></tr><tr><td>Covered amount</td><td>0 EUR</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170425BCR_03_00012345</td></tr><tr><td>Allocated value</td><td>0 RON</td></tr><tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr><tr><td>Asset valuation rate</td><td>75 %</td></tr><tr><td>Base value of asset</td><td>4111367 RON</td></tr><tr><td>Acceptable value</td><td>3083525 RON</td></tr></table></div><div style=\"background-color: lightblue; width: 500px; margin: 20px;\">Directly Secured Loan<table><tr><td>Credit contract nr</td><td>191384497449</td></tr><tr><td>Account ID</td><td>Romania_BCR___000074164</td></tr><tr><td>Loan name</td><td>SELTESTLOAN01</td></tr><tr><td>Limit</td><td>2118 RON</td></tr><tr><td>Risk value</td><td>2118 RON</td></tr><tr><td>Covered amount</td><td>2118 RON</td></tr></table><table style=\"border: solid black 1px;\"><tr><td>Collateral ID</td><td>20170223BCR_04_00012345</td></tr><tr><td>Allocated value</td><td>2118 RON</td></tr><tr><td>Backing asset</td><td>848 - 848 - 4.3. Gold</td></tr><tr><td>Asset valuation rate</td><td>75 %</td></tr><tr><td>Base value of asset</td><td>4111367 RON</td></tr><tr><td>Acceptable value</td><td>3083525 RON</td></tr></table></div></div></div>") );
    }

}
