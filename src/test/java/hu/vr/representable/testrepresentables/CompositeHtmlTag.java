package hu.vr.representable.testrepresentables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.html.AbstractHtmlElement;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class CompositeHtmlTag extends AbstractHtmlContainer {
	
	private AbstractHtmlElement child01 = new SimpleHtmlTag();
	private AbstractHtmlElement child02 = new SimpleHtmlText();

	@Override
	public HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.div;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return null;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text("Inside of a composite html...");
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		return result;
	}

}
