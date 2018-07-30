package org.user.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.user.model.DirectlySecuredLoan;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class DSLDetails extends AbstractHtmlContainer {
	
	private final DirectlySecuredLoan dsl;
	
	public DSLDetails(DirectlySecuredLoan dsl) {
		super();
		this.dsl = dsl;
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
		children.add(new KeyValuePair("Credit contract nr", dsl.getCreditContractNr()));
		children.add(new KeyValuePair("Account ID", dsl.getAccountId()));
		children.add(new KeyValuePair("Loan name", dsl.getLoanName()));
		children.add(new KeyValuePair("Limit", dsl.getLimit()));
		children.add(new KeyValuePair("Risk value", dsl.getRiskValue()));
		children.add(new KeyValuePair("Covered amount", dsl.getCoveredAmt()));
		return children;
	}

	@Override
	public HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.table;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return null;
	}

	@Override
	public TextContent getContent() {
		return null;
	}

}
