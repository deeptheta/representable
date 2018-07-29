package hu.vr.representable.testrepresentables;

import java.util.Map;

import hu.vr.representable.AbstractXmlLeaf;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.Tag;
import hu.vr.representable.taxonomy.TextContent;

public class SimpleTextLeaf extends AbstractXmlLeaf {

	@Override
	public Tag getTag() {
		return null;
	}

	@Override
	public Map<? extends Attribute, AttributeValue> getAttributes() {
		return null;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text("just some text...");
	}

	

	

}
