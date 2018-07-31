package org.user.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.user.model.DirectlySecuredLoan;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.html.elements.FlexBox;
import hu.vr.representable.html.elements.InputButton;
import hu.vr.representable.html.elements.InputField;
import hu.vr.representable.html.elements.Label;
import hu.vr.representable.html.elements.LineBreak;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Final summary page representing several Directly Secured Loans
 */
public class SummaryPage extends AbstractHtmlContainer {
	
	Map<HtmlContainerAttribute, AttributeValue> attributes = new HashMap<>();
	private final List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
	private final FlexBox flexBox = new FlexBox();
	
	public SummaryPage() {
		children.add(new Label(" | Search: "));
		children.add(new InputField(""));
		children.add(new InputButton("Find"));
		children.add(new LineBreak());
		children.add(flexBox);
	}
	
	public void addDSL(DirectlySecuredLoan dsl) {
		if(dsl!=null) {
			flexBox.getChildren().add(new DSLFull(dsl));
		}
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		return children;
	}

	@Override
	public HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.div;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return attributes;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text("Summary Page");
	}

}
