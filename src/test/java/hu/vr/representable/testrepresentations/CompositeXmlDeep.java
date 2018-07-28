package hu.vr.representable.testrepresentations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.XmlRepresentable;

public class CompositeXmlDeep extends AbstractXmlContainer {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	private XmlRepresentable child01 = new SimpleXmlTagWithContent();
	private XmlRepresentable child02 = new SimpleTextLeaf();
	private XmlRepresentable child03 = new CompositeXmlTag();
	
	public CompositeXmlDeep() {
		attributes.put("height", "3");
	}

	@Override
	public List<XmlRepresentable> getChildren() {
		List<XmlRepresentable> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		result.add(child03);
		result.add(child02);
		return result;
	}

	@Override
	protected String getRawTagName() {
		return "deeptag";
	}

	@Override
	protected String getRawContent() {
		return null;
	}

	@Override
	protected Set<String> getRawAttributeKeys() {
		return attributes.keySet();
	}

	@Override
	protected String getRawAttribute(String key) {
		return attributes.get(key);
	}

}
