package hu.vr.representable.testrepresentables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.AbstractXmlElement;
import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.Tag;
import hu.vr.representable.taxonomy.TextContent;

public class CompositeXmlDeep extends AbstractXmlContainer {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	private AbstractXmlElement child01 = new SimpleXmlTagWithContent();
	private AbstractXmlElement child02 = new SimpleTextLeaf();
	private AbstractXmlContainer child03 = new CompositeXmlTag();
	
	public CompositeXmlDeep() {
		attributes.put("height", "3");
	}

	@Override
	public List<XmlRepresentable<? extends Tag, ? extends Attribute>> getChildren() {
		List<XmlRepresentable<? extends Tag, ? extends Attribute>> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		result.add(child03);
		result.add(child02);
		return result;
	}

	@Override
	public Tag getTag() {
		return Tag.tagName("deeptag");
	}

	@Override
	public Map<? extends Attribute, AttributeValue> getAttributes() {
		Map<Attribute, AttributeValue> result = new HashMap<>();
		for(Entry<String, String> entry : attributes.entrySet()) {
			Attribute a = Attribute.attrName(entry.getKey());
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

//	@Override
//	public List<XmlRepresentable<Tag, Attribute>> getChildren() {
//		List<XmlRepresentable<Tag, Attribute>> result = new ArrayList<>();
//		result.add(child01);
//		result.add(child02);
//		result.add(child03);
//		result.add(child02);
//		return result;
//	}
//
//	@Override
//	protected String getRawTagName() {
//		return "deeptag";
//	}
//
//	@Override
//	protected String getRawContent() {
//		return null;
//	}
//
//	@Override
//	protected Set<String> getAttributeKeys() {
//		return attributes.keySet();
//	}
//
//	@Override
//	protected String getRawAttribute(String key) {
//		return attributes.get(key);
//	}

}
