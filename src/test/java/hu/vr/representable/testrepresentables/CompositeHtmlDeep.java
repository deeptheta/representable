package hu.vr.representable.testrepresentables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.html.AbstractHtmlElement;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.attributes.HtmlContainerAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class CompositeHtmlDeep extends AbstractHtmlContainer {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	private AbstractHtmlElement child01 = new SimpleHtmlTag();
	private AbstractHtmlElement child02 = new SimpleHtmlText();
	private AbstractHtmlContainer child03 = new CompositeHtmlTag();
	
	public CompositeHtmlDeep() {
		attributes.put("height", "3");
	}

	@Override
	public List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> getChildren() {
		List<XmlRepresentable<? extends HtmlTag, ? extends HtmlAttribute>> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		result.add(child03);
		result.add(child02);
		return result;
	}

	@Override
	public HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.div;
	}

	@Override
	public Map<? extends HtmlContainerAttribute, AttributeValue> getAttributes() {
		Map<HtmlContainerAttribute, AttributeValue> result = new HashMap<>();
		for(Entry<String, String> entry : attributes.entrySet()) {
			HtmlContainerAttribute a = HtmlContainerAttribute.Domain.QUERY.getElementBy(entry.getKey());//HtmlContainerAttribute.DomainElement.attrName(entry.getKey());
			if(a!=null) {
				result.put(a, AttributeValue.attrValue(entry.getValue()));
			}
		}
		return result;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text("Deep element starts...");
	}

}
