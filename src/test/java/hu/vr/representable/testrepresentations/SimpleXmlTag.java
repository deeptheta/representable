package hu.vr.representable.testrepresentations;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import hu.vr.representable.AbstractXmlLeaf;
import hu.vr.representable.Attribute;
import hu.vr.representable.AttributeValue;
import hu.vr.representable.Tag;
import hu.vr.representable.TextContent;

public class SimpleXmlTag extends AbstractXmlLeaf {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	public SimpleXmlTag() {
		attributes.put("play-doh", "O'Reilly2018");
		attributes.put("quick'n'dirty", "try \"dblquotes\"");
	}

	@Override
	public Tag getTag() {
		return Tag.Domain.tagName("simple tag");
	}

	@Override
	public Map<? extends Attribute, AttributeValue> getAttributes() {
		Map<Attribute, AttributeValue> result = new HashMap<>();
		for(Entry<String, String> entry : attributes.entrySet()) {
			result.put(Attribute.Domain.attrName(entry.getKey()),
					AttributeValue.Domain.attrValue(entry.getValue()));
		}
		return result;
	}

	@Override
	public TextContent getContent() {
		return null;
	}
	
//	@Override
//	protected Set<Attribute> getAttributeKeys() {
//		Set<Attribute> result = new HashSet<>();
//		for(String keyString : attributes.keySet()) {
//			result.add(Attribute.Domain.attrName(keyString));
//		}
//		return result;
//	}
//	
//	@Override
//	protected String getAttributeRawValue(Attribute key) {
//		return attributes.get(key.toString());
//	}
//	
//	@Override
//	protected String getRawContent() {
//		return null;
//	}

}
