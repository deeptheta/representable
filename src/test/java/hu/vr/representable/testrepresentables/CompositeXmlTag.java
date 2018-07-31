package hu.vr.representable.testrepresentables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.AbstractXmlElement;
import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.Tag;
import hu.vr.representable.taxonomy.TextContent;

public class CompositeXmlTag extends AbstractXmlContainer {
	
	private AbstractXmlElement child01 = new SimpleXmlTag();
	private AbstractXmlElement child02 = new SimpleTextLeaf();
	
	@Override
	public List<XmlRepresentable<? extends Tag, ? extends Attribute>> getChildren() {
		List<XmlRepresentable<? extends Tag, ? extends Attribute>> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		return result;
	}
	
	@Override
	public Tag getTag() {
		return Tag.tagName("complex tag");
	}
	
	@Override
	public Map<? extends Attribute, AttributeValue> getAttributes() {
		return null;
	}
	
	@Override
	public TextContent getContent() {
		return TextContent.text("This is some rather complex textual content...");
	}

}
