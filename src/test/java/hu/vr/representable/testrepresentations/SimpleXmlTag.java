package hu.vr.representable.testrepresentations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hu.vr.representable.AbstractXmlLeaf;

public class SimpleXmlTag extends AbstractXmlLeaf {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	public SimpleXmlTag() {
		attributes.put("play-doh", "O'Reilly2018");
		attributes.put("quick'n'dirty", "try \"dblquotes\"");
	}

	@Override
	protected String getRawTagName() {
		return "simpletag";
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
