package hu.vr.representable.testrepresentables;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import hu.vr.representable.html.AbstractHtmlLeaf;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.attributes.HtmlAttribute;
import hu.vr.representable.taxonomy.html.tags.HtmlTag;

public class SimpleHtmlTag extends AbstractHtmlLeaf {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	public SimpleHtmlTag() {
		attributes.put("id", "simple001");
		attributes.put("non-existent attribute", "try \"dblquotes\"");
	}

	@Override
	public HtmlTag getTag() {
		return HtmlTag.DomainElement.div;
	}

	@Override
	public Map<? extends HtmlAttribute, AttributeValue> getAttributes() {
		Map<HtmlAttribute, AttributeValue> result = new HashMap<>();
		for(Entry<String, String> entry : attributes.entrySet()) {
			HtmlAttribute a = HtmlAttribute.Domain.QUERY.getElementBy(entry.getKey());//Attribute.attrName(entry.getKey(), HtmlAttribute.Domain.DOMAIN);//HtmlAttribute.DomainElement.attrName(entry.getKey());
			if(a!=null) {
				result.put(a, AttributeValue.attrValue(entry.getValue()));
			}
		}
		return result;
	}

	@Override
	public TextContent getContent() {
		return null;
	}

}
