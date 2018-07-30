package org.user.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.user.model.Collateral;
import org.user.model.DirectlySecuredLoan;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.renderer.RendererService;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * A representation of DirectlySecuredLoan, done by composition.
 * 
 * But it could equally well be done through inheritance
 * (extends DirectlySecuredLoan, bypassing AbstractHtmlContainer convenience class and implementing
 * XmlRepresentableContainer<HtmlContainerTag, HtmlContainerAttribute, HtmlTag, HtmlAttribute>).
 * 
 * @author Viktor Remeli
 *
 */
public class DSLFull extends AbstractHtmlContainer implements DSLRepresentation {
	
	private final DirectlySecuredLoan dsl;
	Map<HtmlContainerAttribute, AttributeValue> attributes = new HashMap<>();
	private final List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
		
	public DSLFull(DirectlySecuredLoan dsl) {
		super();
		this.dsl = dsl;
		children.add(new DSLDetailsSheet(this.dsl));
		
		if(dsl!=null && dsl.getCollaterals()!=null) {
			for(Collateral coll : dsl.getCollaterals()) {
				children.add(new CollateralAssetSheet(coll));
			}
		}
		
		this.setStyle("background-color: lightblue; width: 500px; margin: 20px;");
	}
	
	public void setStyle(String styleCss) {
		attributes.put(HtmlContainerAttribute.DomainElement.style, AttributeValue.attrValue(styleCss));
	}

	@Override
	public final HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.div;
	}

	@Override
	public final TextContent getContent() {
		return TextContent.text("Directly Secured Loan");
	}

	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return attributes;
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		return children;
	}

}
