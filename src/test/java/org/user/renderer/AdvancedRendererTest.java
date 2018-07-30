package org.user.renderer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.user.elements.DSLComposed;
import org.user.elements.DSLRepresentation;
import org.user.elements.Text;
import org.user.system.CollateralManagement;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class AdvancedRendererTest {
	
	AdvancedRenderer advRenderer = new AdvancedRenderer();
	
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
				children.add(new Text("</br>or here"));
				return children;
			}
		};
        String result = advRenderer.render(otherCont);
        System.out.println("other composed:    " + result);
        
        assertTrue( "<a>click here&lt;/br&gt;or here</a>".equals(result) );
    }
	
	@Test
    public void renderDSLSimple() {
        DSLRepresentation dsl = new DSLComposed(CollateralManagement.DSL01);
        String result = advRenderer.render(dsl);
        System.out.println("dsl simple    :    " + result);
        
        assertTrue( ("<div style=\"background-color:lightblue;\">Directly Secured Loan<table>"
        		+ "<tr><td>Credit contract nr</td><td>1056201613067</td></tr>"
        		+ "<tr><td>Account ID</td><td>Romania_BCR___000074169</td></tr>"
        		+ "<tr><td>Loan name</td><td>SELTESTLOAN01</td></tr>"
        		+ "<tr><td>Limit</td><td>9737 RON</td></tr>"
        		+ "<tr><td>Risk value</td><td>9737 RON</td></tr>"
        		+ "<tr><td>Covered amount</td><td>5 RON</td></tr></table></div>").equals(result) );
    }

}
