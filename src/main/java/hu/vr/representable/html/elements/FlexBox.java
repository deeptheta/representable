package hu.vr.representable.html.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

/**
 * Is a CSS3 flexible-layout [div]...[/div] container UI element.
 */
public class FlexBox extends AbstractHtmlContainer {
	
	private static final String flexStyle = "display: flex; flex-wrap: wrap; ";
	
	private final Map<HtmlContainerAttribute, AttributeValue> attributes = new HashMap<>();
	private final List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> children = new ArrayList<>();
	
	public FlexBox() {
		attributes.put(HtmlContainerAttribute.DomainElement.style, AttributeValue.attrValue(flexStyle));
	}
	
	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		return children;
	}

	@Override
	public final HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.div;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		return attributes;
	}

	@Override
	public final TextContent getContent() {
		return null;
	}
	
	/**
	 * @param additional styling
	 */
	public void setStyle(String styleText) {
		attributes.put(HtmlContainerAttribute.DomainElement.style, AttributeValue.attrValue(flexStyle+styleText));
	}

}
