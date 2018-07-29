package hu.vr.representable.testrepresentations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.AbstractXmlLeaf;
import hu.vr.representable.Attribute;
import hu.vr.representable.AttributeValue;
import hu.vr.representable.Tag;
import hu.vr.representable.TextContent;
import hu.vr.representable.XmlRepresentable;

public class CompositeXmlTag extends AbstractXmlContainer {
	
	private AbstractXmlLeaf child01 = new SimpleXmlTag();
	private AbstractXmlLeaf child02 = new SimpleTextLeaf();
	
	@Override
	public List<XmlRepresentable<? extends Tag, ? extends Attribute>> getChildren() {
		List<XmlRepresentable<? extends Tag, ? extends Attribute>> result = new ArrayList<>();
		result.add(child01);
		result.add(child02);
		return result;
	}
	
	@Override
	public Tag getTag() {
		return Tag.Domain.tagName("complex tag");
	}
	
	@Override
	public Map<? extends Attribute, AttributeValue> getAttributes() {
		return null;
	}
	
	@Override
	public TextContent getContent() {
		return TextContent.Domain.text("This is some rather complex textual content...");
	}

//	@Override
//	public List<XmlRepresentable<Tag, Attribute>> getChildren() {
//		List<XmlRepresentable<Tag, Attribute>> result = new ArrayList<>();
//		result.add(child01);
//		result.add(child02);
//		return result;
//	}
//
//	@Override
//	protected String getRawTagName() {
//		return "complex tag";
//	}
//
//	@Override
//	protected String getRawContent() {
//		return "This is some rather complex textual content...";
//	}
//
//	@Override
//	protected Set<String> getAttributeKeys() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected String getRawAttribute(String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
