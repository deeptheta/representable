package hu.vr.representable.testrepresentations;

import java.util.Set;

import hu.vr.representable.AbstractXmlLeaf;

public class SimpleTextLeaf extends AbstractXmlLeaf {

	@Override
	protected String getRawTagName() {
		return null;
	}

	@Override
	protected String getRawContent() {
		return "just some text...";
	}

	@Override
	protected Set<String> getRawAttributeKeys() {
		return null;
	}

	@Override
	protected String getRawAttribute(String key) {
		return null;
	}

}
