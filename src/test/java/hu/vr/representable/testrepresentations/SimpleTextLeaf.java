package hu.vr.representable.testrepresentations;

import java.util.Map;

import hu.vr.representable.AbstractXmlLeaf;
import hu.vr.representable.Attribute;
import hu.vr.representable.AttributeValue;
import hu.vr.representable.Tag;
import hu.vr.representable.TextContent;

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
		return TextContent.Domain.text("just some text...");
	}

	

	

}
